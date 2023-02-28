package companion.challeculum.domains.mission;

import companion.challeculum.common.Constants;
import companion.challeculum.common.UpdateRecordUtil;
import companion.challeculum.domains.mission.dto.Mission;
import companion.challeculum.domains.mission.dto.MissionCreateDto;
import companion.challeculum.domains.mission.dto.MissionJoined;
import companion.challeculum.domains.user.dto.UserGround;
import companion.challeculum.domains.user.dto.UserGroundJoined;
import companion.challeculum.domains.user.dto.UserMissionJoined;
import companion.challeculum.domains.user.repositories.UserGroundDao;
import companion.challeculum.domains.user.repositories.UserMissionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionDao missionDao;
    private final UserGroundDao userGroundDao;
    private final UserMissionDao userMissionDao;
    private final UpdateRecordUtil updateRecordUtil;

    public void insertMission(MissionCreateDto mission) {
        missionDao.insert(mission);
    }

    @Override
    public void updateMission(long missionId, Mission missionDTO) {
        Map<String, Object> updateMap = updateRecordUtil.generateUpdateMap(missionDTO, Constants.TO_SNAKE_CASE, Function.identity());
        missionDao.update(missionId, updateMap);
    }

    public MissionJoined getMission(long id) {
        return missionDao.getMissionJoinedByMissionId(id);
    }

    @Override
    public List<MissionJoined> getMyOngoingMissionList(long userId) {
        LocalDate now = LocalDate.now();
        List<List<MissionJoined>> list = new ArrayList<>();
        List<UserGround> userGroundList = userGroundDao.getUserGroundListByUserId(userId);
        userGroundList.forEach(ug ->
                list.add(missionDao.getMissionJoinedList(ug.getGroundId())
                        .stream().filter(userMission -> now.isEqual(userMission.getMissionAt())).toList()));
        return list.stream().flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @Override
    public String getMyMissionSuccessRate(long userId) {
        LocalDate now = LocalDate.now();
        List<UserGroundJoined> userGroundList = userGroundDao.getUserGroundJoinedListByUserId(userId);
        List<Mission> totalMissionListUntilNow = userGroundList.stream().filter(ug -> !ug.getStatus().equals(Constants.GROUND_STANDBY)
                ).map(ug -> missionDao.getMissionList(ug.getGroundId()))
                .flatMap(List::stream).filter(mission -> now.isAfter(mission.getMissionAt()))
                .toList();
        List<UserMissionJoined> successMissionList = userMissionDao.getUserMissionJoinedByUserId(userId).stream()
                .filter(um -> um.getIsAccepted().equals(Constants.USER_MISSION_ACCEPTED) && now.isAfter(um.getMissionAt()))
                .toList();
        double successRate = (double) successMissionList.size() / (double) totalMissionListUntilNow.size();
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(successRate);
    }

    public List<Mission> getMissionListByGroupId(long groundId) {
        return missionDao.getMissionList(groundId).stream().filter(mission -> mission.getGroundId() == groundId).toList();
    }
}

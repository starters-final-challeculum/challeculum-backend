package companion.challeculum.domains.mission;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.common.Constants;
import companion.challeculum.domains.mission.dtos.Mission;
import companion.challeculum.domains.userground.UserGroundDao;
import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import companion.challeculum.domains.usermission.UserMissionDao;
import companion.challeculum.domains.usermission.dtos.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService implements MissionInfoService {
    private final MissionDao missionDao;
    private final UserGroundDao userGroundDao;
    private final AuthUserManager authUserManager;

    private final UserMissionDao userMissionDao;

//    @Override
//    public void updateMission(Long id, Mission missionDTO) {
//        Mission mission = missionDao.selectMission(id);
//        if (mission != null) {
//            mission.setGroundId(missionDTO.getGroundId());
//            mission.setAssignment(missionDTO.getAssignment());
//            mission.setStartAt(missionDTO.getStartAt());
//            mission.setEndAt(missionDTO.getEndAt());
//            missionDao.updateMission(mission);
//        } else {
//            throw new IllegalStateException("회원이 존재하지 않습니다.");
//        }
//    }

    public Mission selectMission(Long id) {
        return missionDao.selectMission(id);
    }

    public List<Mission> selectAllMissionInfo() {
        return missionDao.selectAllMissionInfo();
    }

    public void insertMission(Mission mission) {
        missionDao.registerMission(mission);
    }

    public void deleteMission(Long id) {
        if (missionDao.selectMission(id) != null) {
            missionDao.deleteMission(id);
        } else {
            throw new IllegalStateException("미션이 존재하지 않습니다.");
        }
    }

//    @Override
//    public List<Mission> getMyOngoingMissionList(Authentication authentication) {
//        LocalDate now = LocalDate.now();
//        List<List<Mission>> list = new ArrayList<>();
//        List<UserGround> userGroundList = userGroundDao.getUserGroundListByUserId(authUserManager.getSessionId(authentication));
//        userGroundList.forEach(ug ->
//                list.add(missionDao.getMissionList(ug.getGroundId())
//                        .stream().filter(userMission ->
//                                !now.isBefore(userMission.getStartAt()) && !now.isAfter(userMission.getEndAt())).toList()));
//        return list.stream().flatMap(List::stream)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getMyMissionSuccessRate(Authentication authentication) {
//        LocalDate now = LocalDate.now();
//        Long userId = authUserManager.getSessionId(authentication);
//        List<UserGroundJoined> userGroundList = userGroundDao.getUserGroundJoinedListByUserId(userId);
//        List<Mission> totalMissionListUntilNow = userGroundList.stream().filter(ug ->
//                        ug.getIsAttending() == 1 && (ug.getStatus().equals(Constants.GROUND_ONGOING) || ug.getStatus().equals(Constants.GROUND_COMPLETED))
//                ).map(ug -> missionDao.getMissionList(ug.getGroundId()))
//                .flatMap(List::stream).filter(mission -> now.isAfter(mission.getEndAt()))
//                .toList();
//        List<UserMission> successMissionList = userMissionDao.getUserMissionByUserId(userId).stream().filter(um -> um.getIsAccepted().equals(Constants.USER_MISSION_ACCEPTED)).toList();
//        double successRate = (double) successMissionList.size() / (double) totalMissionListUntilNow.size();
//        DecimalFormat df = new DecimalFormat("#.##");
//        return df.format(successRate);
//    }

    public List<Mission> getMissionListByGroupId(long groundId){
        List<Mission> MissionLists=missionDao.getMissionList(groundId).stream().filter(mission -> mission.getGroundId()==groundId).toList();
        return MissionLists;
    }
}

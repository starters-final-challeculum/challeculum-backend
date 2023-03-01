package companion.challeculum.domains.ground;

import companion.challeculum.common.Constants;
import companion.challeculum.common.UpdateRecordUtil;
import companion.challeculum.common.exceptions.intented.CannotDeleteGroundException;
import companion.challeculum.common.exceptions.intented.UserPointDeficiencyException;
import companion.challeculum.domains.ground.dto.Ground;
import companion.challeculum.domains.ground.dto.GroundCreateDto;
import companion.challeculum.domains.ground.dto.GroundJoined;
import companion.challeculum.domains.ground.dto.GroundUpdateDto;
import companion.challeculum.domains.mission.MissionDao;
import companion.challeculum.domains.user.dto.User;
import companion.challeculum.domains.user.dto.UserUpdateDto;
import companion.challeculum.domains.user.repositories.UserDao;
import companion.challeculum.domains.user.repositories.UserGroundDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static companion.challeculum.common.Constants.ROWS_PER_PAGE;

@Service
@RequiredArgsConstructor
@Transactional
public class GroundServiceImpl implements GroundService {
    private final GroundDao groundDao;
    private final MissionDao missionDao;
    private final UserGroundDao userGroundDao;
    private final UpdateRecordUtil updateRecordUtil;
    private final UserDao userDao;

    @Override
    public void deleteGround(User user, long groundId) {
        Ground ground = groundDao.getGroundByGroundId(groundId);
        if (!ground.getStatus().equals(Constants.GROUND_STANDBY))
            throw new CannotDeleteGroundException("진행중이거나 종료된 그라운드는 삭제할 수 없습니다.");
        if (user.getUserId() != ground.getCreateUserId() && user.getRole().equals(Constants.ROLE_MEMBER)) {
            throw new AccessDeniedException("그라운드 생성자만 그라운드를 삭제할 수 있습니다.");
        }
        userGroundDao.getUserGroundJoinedListByGroundId(groundId).forEach(userGround -> {
            UserUpdateDto userUpdateDto = new UserUpdateDto();
            userUpdateDto.setPoint(userGround.getPoint() + ground.getDeposit());
            Map<String, Object> newUpdatedMap = updateRecordUtil.generateUpdateMap(userUpdateDto,
                    Constants.TO_SNAKE_CASE, Function.identity());
            userDao.update(userGround.getUserId(), newUpdatedMap);
        });
        groundDao.deleteGround(groundId);
    }


    @Override
    public List<GroundJoined> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword) {
        int startRow = ROWS_PER_PAGE * (page - 1);
        Map<String, String> filterMap = new HashMap<>();
        String[] pairs = filter.split(",");
        Arrays.stream(pairs).filter(p -> !(p.equals(""))).forEach(p -> {
            String[] keyValue = p.split(":");
            if (!keyValue[1].equals("0") || !keyValue[1].equals("undefiend")) filterMap.put(keyValue[0], keyValue[1]);
        });
        List<GroundJoined> groundJoinedList = groundDao.getGroundList(startRow, ROWS_PER_PAGE, filterMap, sortBy, orderBy, keyword);
        return fecthJoinMissionList(groundJoinedList);

    }


    @Override
    public List<GroundJoined> getGroundsByMe(long userId) {
        List<GroundJoined> groundJoinedList = groundDao.getGroundsByMe(userId);
        return fecthJoinMissionList(groundJoinedList);
    }

    @Override
    public void updateGround(long groundId, GroundUpdateDto groundUpdateDto) {
        Map<String, Object> newUpdatedMap = updateRecordUtil.generateUpdateMap(groundUpdateDto,
                Constants.TO_SNAKE_CASE, Function.identity());
        groundDao.update(groundId, newUpdatedMap);
    }

    @Override
    public List<GroundJoined> getMyGrounds(long userId, String status) {
        List<GroundJoined> groundJoinedList = groundDao.getMyGrounds(userId, status);
        return fecthJoinMissionList(groundJoinedList);
    }

    //    Redesign(2/25)
    @Override
    public void createGround(User user, GroundCreateDto dto) {
        long userId = user.getUserId();
        int userPoint = user.getPoint();
        if (dto.getDeposit() > userPoint) throw new UserPointDeficiencyException("그라운드에 개설하기 위한 포인트가 부족합니다.");
        dto.setCreateUserId(userId);
        groundDao.insert(dto);
        long groundId = groundDao.getLastInsertedId();
        dto.getMissionList().forEach(missionCreateDto -> {
            missionCreateDto.setGroundId(groundId);
            missionDao.insert(missionCreateDto);
        });
        userGroundDao.insert(dto.getCreateUserId(), groundId);
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setPoint(userPoint - dto.getDeposit());
        Map<String, Object> newUpdatedMap = updateRecordUtil.generateUpdateMap(userUpdateDto,
                Constants.TO_SNAKE_CASE, Function.identity());
        userDao.update(userId, newUpdatedMap);

    }

    @Override
    public Ground getGroundByGroundId(long groundId) {
        return groundDao.getGroundByGroundId(groundId);
    }

    @Override
    public GroundJoined getGroundJoinedByGroundId(long groundId) {
        GroundJoined groundJoined = groundDao.getGroundJoinedByGroundId(groundId);
        int numOfParticipants = userGroundDao.getUserGroundJoinedListByGroundId(groundId).size();
        groundJoined.setNumOfParticipants(numOfParticipants);
        groundJoined.setMissionList(missionDao.getMissionList(groundId));
        return groundJoined;
    }

    private List<GroundJoined> fecthJoinMissionList(List<GroundJoined> groundJoinedList) {
        return groundJoinedList.stream()
                .peek(groundJoined -> groundJoined.setMissionList(missionDao.getMissionList(groundJoined.getGroundId())))
                .toList();
    }
}

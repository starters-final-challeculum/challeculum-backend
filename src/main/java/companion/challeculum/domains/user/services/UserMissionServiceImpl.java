package companion.challeculum.domains.user.services;

import companion.challeculum.common.Constants;
import companion.challeculum.common.UpdateRecordUtil;
import companion.challeculum.common.exceptions.intented.NoSubmittedMissionExistException;
import companion.challeculum.domains.ground.GroundDao;
import companion.challeculum.domains.ground.dto.Ground;
import companion.challeculum.domains.user.dto.UserMission;
import companion.challeculum.domains.user.dto.UserMissionJoined;
import companion.challeculum.domains.user.repositories.UserMissionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class UserMissionServiceImpl implements UserMissionService {
    private final UserMissionDao userMissionDao;

    private final UpdateRecordUtil updateRecordUtil;

    private final GroundDao groundDao;

    public void createUserMission(long userId, int missionId, String imageUrl) {
        userMissionDao.createUserMission(userId, missionId, imageUrl);
    }

    public void updateUserMission(UserMission userMission, long userId, long missionId) {
        UserMission selectUserMission = userMissionDao.getUserMissionByUserId(userId, missionId);
        if (selectUserMission != null) {
            selectUserMission.setSubmitAt(userMission.getSubmitAt());
            selectUserMission.setIsAccepted(userMission.getIsAccepted());
            selectUserMission.setImageUrl(userMission.getImageUrl());
            userMissionDao.updateUserMission(selectUserMission);
        } else {
            throw new NoSubmittedMissionExistException("유저는 미션을 시작하지 않았습니다.");
        }
    }

    @Override
    public void updateUserMissionByAdmin(UserMission userMission, long userId, long missionId) {
        Map<String, Object> updateMap = updateRecordUtil.generateUpdateMap(userMission, Constants.TO_SNAKE_CASE, Function.identity());
        userMissionDao.update(userId, missionId, updateMap);
    }

    @Override
    public UserMission getUserMissionByUserId(long userId, long missionId) {
        return userMissionDao.getUserMissionByUserId(userId, missionId);
    }

    public List<UserMission> getAllUserMission(Authentication authentication) {
        return userMissionDao.getAllUserMission();
    }

    @Override
    public UserMission getUserMission(Long userId, long missionId) {
        return userMissionDao.getUserMissionByUserIdAndMissionId(userId, missionId);
    }

    @Override
    public List<UserMissionJoined> getAllUserMissionExtended() {
        List<UserMissionJoined> userMissionList = userMissionDao.getAllUserMissionJoined();
        return userMissionList.stream().peek(userMissionJoined -> {
            Ground ground = groundDao.getGroundByGroundId(userMissionJoined.getGroundId());
            userMissionJoined.setGround(ground);
        }).toList();
    }
}


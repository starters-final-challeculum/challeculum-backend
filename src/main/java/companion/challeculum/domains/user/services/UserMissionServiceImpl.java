package companion.challeculum.domains.user.services;

import com.amazonaws.services.docdbelastic.model.Auth;
import companion.challeculum.common.exceptions.intented.NoSubmittedMissionExistException;
import companion.challeculum.domains.user.dto.UserMission;
import companion.challeculum.domains.user.repositories.UserMissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usermissionService")
public class UserMissionServiceImpl implements UserMissionService {
    @Autowired
    UserMissionDao userMissionDao;

    public void createUserMission(long userId, int missionId, String imageUrl) {
        userMissionDao.createUserMission(userId, missionId, imageUrl);
    }

    public void updateUserMission(UserMission userMission, long userId, long missionId) {
        UserMission selectUserMission = userMissionDao.getUserMissionByUserId(userId, missionId);
        if (selectUserMission != null) {
            selectUserMission.setIsAccepted(userMission.getIsAccepted());
            userMissionDao.updateUserMission(selectUserMission);
        } else {
            throw new NoSubmittedMissionExistException("유저는 미션을 시작하지 않았습니다.");
        }
    }

    @Override
    public UserMission getUserMissionByUserId(long userId, long missionId) {
        return userMissionDao.getUserMissionByUserId(userId, missionId);
    }

    public List<UserMission> getAllUserMission(Authentication authentication) {
        return userMissionDao.getAllUserMission();
    }
}


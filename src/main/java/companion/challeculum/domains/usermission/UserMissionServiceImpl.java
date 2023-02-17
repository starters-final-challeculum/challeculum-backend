package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMissionServiceImpl implements UserMissionService {
    @Autowired
    private UserMissionDao userMissionDao;

    public void createUserMission(UserMission userMission) {
        userMissionDao.insertUser(userMission);
    }
}

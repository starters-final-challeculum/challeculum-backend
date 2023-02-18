package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMissionServiceImpl implements UserMissionService {
    ////// common
    @Autowired
    private UserMissionDao userMissionDao;
    ////// common

    //// Jonghyun
    //// End of Jonghyun

    /////// Kiyoung
    public void createUserMission(UserMission userMission) {
        userMissionDao.insertUser(userMission);
    }
    /////// End of Kiyoung

    //////Sojeong
    //////End of Sojeeong

    //////Hwajun
    //////End of Hwajun

    //////Hyunjoon
    //////End of Hyunjoon
}

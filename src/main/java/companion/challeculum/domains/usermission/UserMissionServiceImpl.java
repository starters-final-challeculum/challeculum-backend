package companion.challeculum.domains.usermission;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.mission.MissionDao;
import companion.challeculum.domains.userground.UserGroundDao;
import companion.challeculum.domains.usermission.dtos.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionServiceImpl implements UserMissionService {
    ////// common
    private final UserMissionDao userMissionDao;
    private final AuthUserManager authUserManager;
    private final UserGroundDao userGroundDao;
    private final MissionDao missionDao;
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

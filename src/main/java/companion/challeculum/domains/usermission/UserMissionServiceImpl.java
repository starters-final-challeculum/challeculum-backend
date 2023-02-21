package companion.challeculum.domains.usermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usermissionService")
public class UserMissionServiceImpl implements UserMissionService {
    @Autowired
    UserMissionDao userMissionDao;

    public void createUserMission(long userId, int missionId, String imageUrl){
        userMissionDao.createUserMission(userId,missionId,imageUrl);
    }
}

package companion.challeculum.domains.usermission;

import org.springframework.beans.factory.annotation.Autowired;

public class UserMissionServiceImpl implements UserMissionService {
    @Autowired
    private UserMissionRepository userMissionRepository;

    public void createUserMission(UserMissionDTO userMission) {
        userMissionRepository.insertUser(userMission);
    }
}

package companion.challeculum.domains.user.usermission;

import companion.challeculum.domains.user.usermission.dtos.UserMission;

public interface UserMissionService {
    void createUserMission(long userId,int missionId, String imageUrl);


    void updateUserMission(UserMission userMission, long userId,long missionId);

    UserMission getUserMissionByUserId(long userId,long missionId);


}

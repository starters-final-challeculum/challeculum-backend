package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;

import java.util.List;

public interface UserMissionService {
    void createUserMission(long userId,int missionId, String imageUrl);


    void updateUserMission(UserMission userMission, long userId,long missionId);

    UserMission getUserMissionByUserId(long userId,long missionId);


}

package companion.challeculum.domains.user.repositories;

import companion.challeculum.domains.user.dto.User;
import companion.challeculum.domains.user.dto.UserMission;
import companion.challeculum.domains.user.dto.UserMissionJoined;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMissionDao {
    List<UserMission> getUserMissionByUserId(Long sessionId);

    List<UserMissionJoined> getUserMissionJoinedByUserId(Long sessionId);

    UserMission getUserMissionByUserId(long userId, long missionId);

    void createUserMission(long userId, int missionId, String imageUrl);

    void createUserMission(UserMission userMissionFile);

    void updateUserMission(UserMission userMission);

    List<UserMission> getAllUserMission();
}

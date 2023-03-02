package companion.challeculum.domains.user.repositories;

import companion.challeculum.domains.user.dto.UserMission;
import companion.challeculum.domains.user.dto.UserMissionJoined;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    List<UserMissionJoined> getAllUserMissionJoined();

    UserMission getUserMissionByUserIdAndMissionId(long userId, long missionId);
    void update(@Param("userId") long userId, @Param("missionId") long missionId, @Param("updateMap") Map<String, Object> updateMap);
}

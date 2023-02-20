package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface UserMissionDao {

    List<UserMission> getUserMissionByUserId(Long sessionId);

    void createUserMission(UserMission userMissionFile);

    void createUserMission(long userId, int missionId, String imageUrl);
}

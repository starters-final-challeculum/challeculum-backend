package companion.challeculum.domains.user.repositories;

import companion.challeculum.domains.user.dto.UserGround;
import companion.challeculum.domains.user.dto.UserGroundJoined;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserGroundDao {
    void insert(long userId, long groundId);

    void delete(long userId, long groundId);

    UserGround getUserGround(long userId, long groundId);

    UserGroundJoined getUserGroundJoined(long userId, long groundId);

    List<UserGround> getUserGroundListByGroundId(long groundId);

    List<UserGroundJoined> getUserGroundJoinedListByGroundId(long groundId);

    List<UserGround> getUserGroundListByUserId(long userId);

    List<UserGroundJoined> getUserGroundJoinedListByUserId(long userId);

    int getUserGroundSuccessCountByGroundId(long groundId);

    List<UserGroundJoined> getUserGroundJoinedListByUserIdAndStatus(long userId, String status, int limit, int offset);
}
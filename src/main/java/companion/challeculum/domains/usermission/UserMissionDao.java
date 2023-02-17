package companion.challeculum.domains.usermission;

import companion.challeculum.domains.usermission.dtos.UserMission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMissionDao {
    void insertUser(UserMission userMission);

}

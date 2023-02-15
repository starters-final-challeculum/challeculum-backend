package companion.challeculum.domains.usermission;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMissionRepository {
    void insertUser(UserMissionDTO userMissionDTO);

}

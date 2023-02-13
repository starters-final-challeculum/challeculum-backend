package companion.challeculum.domains.ground;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GroundDAO {
    void deleteGround(long groundId);
}

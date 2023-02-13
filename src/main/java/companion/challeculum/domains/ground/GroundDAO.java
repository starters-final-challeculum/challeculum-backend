package companion.challeculum.domains.ground;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GroundDAO {
    void deleteGround(long groundId);

    GroundDTO showGroundDetail(long groundId);

    List<GroundDTO> getGrounds(@Param("page") int page, @Param("categoryId") Integer categoryId, @Param("level") Integer level);
}

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

    List<GroundDTO> getGrounds(@Param("startRow") int startRow,
                               @Param("ROWS_PER_PAGE") int ROWS_PER_PAGE,
                               @Param("categoryId") Integer categoryId,
                               @Param("level") Integer level);

    void createGround(GroundDTO groundDTO);
}

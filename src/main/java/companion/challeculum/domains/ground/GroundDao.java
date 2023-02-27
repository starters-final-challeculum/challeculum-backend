package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GroundDao {
    long insert(GroundCreateDto dto);
    void update(@Param("groundId") long groundId, @Param("updateMap") Map<String, Object> updateMap);
    void deleteGround(long groundId);
    long getLastInsertedId();
    List<GroundJoined> getGroundList(@Param("offset") int offset,
                                     @Param("limit") int limit,
                                     @Param("filterMap") Map<String, String> filterMap,
                                     @Param("sortBy") String sortBy,
                                     @Param("orderBy") String orderBy,
                                     @Param("keyword") String keyword);
    List<GroundJoined> getGroundsByMe(long userId);
    List<GroundJoined> getMyGrounds(long userId, String status);
    Ground getGroundByGroundId(long groundId);
    GroundJoined getGroundJoinedByGroundId(long groundId);
}

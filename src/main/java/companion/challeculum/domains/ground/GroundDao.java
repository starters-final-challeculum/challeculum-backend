package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.mission.dtos.MissionCreateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GroundDao {
    void deleteGround(long groundId);

    Ground showGroundDetail(long groundId);

    List<GroundJoined> getGrounds(@Param("startRow") Integer startRow,
                                  @Param("ROWS_PER_PAGE") int ROWS_PER_PAGE,
                                  @Param("categoryId") Integer categoryId,
                                  @Param("level") Integer level);

    void createGround(GroundCreateDto groundCreateDTO);

    List<Map<String, Object>> getMyGrounds(@Param("userId") long userId,
                                           @Param("startRow") int startRow,
                                           @Param("ROWS_PER_PAGE") int rowsPerPage,
                                           @Param("status") String status);

    void refundDeposit(long groundId);

    void markNotAttending(long groundId);

    void addMissionsToGround(List<MissionCreateDto> missionList);
}

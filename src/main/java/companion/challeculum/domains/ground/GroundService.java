package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;

import java.util.List;
import java.util.Map;

public interface GroundService {
    int getDepositById(long groundId);
    void deleteGround(long groundId);

    Map<String, Object> getGround(long groundId);

    List<Map<String,Object>> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword);

    List<Map<String, Object>> getGroundsByMe(long userId);

    void createGround(GroundCreateDto groundCreateDTO);

    List<Map<String,Object>> getMyGroundList(long userId, Integer page, String status);

    int updateGround(long groundId, GroundUpdateDto groundUpdateDto);

    Long getGroundCreator(long groundId);

    List<Map<String, Object>> getMyGrounds(long userId);
}

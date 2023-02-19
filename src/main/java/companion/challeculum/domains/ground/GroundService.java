package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;

import java.util.List;
import java.util.Map;

public interface GroundService {
    void deleteGround(long groundId);

    Ground showGroundDetail(long groundId);

    List<GroundJoined> getGrounds(Integer page, Integer categoryId, Integer level);

    void createGround(GroundCreateDto groundCreateDTO);

    List<Map<String,Object>> getMyGroundList(long userId, Integer page, String status);
}

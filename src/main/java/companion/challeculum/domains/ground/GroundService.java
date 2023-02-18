package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;

import java.util.List;
import java.util.Map;

public interface GroundService {
    void deleteGround(long groundId);

    Ground showGroundDetail(long groundId);

    List<GroundJoined> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword);

    void createGround(GroundCreateDto groundCreateDTO);

    List<Map<String, Object>> getMyGroundList(long userId, int page, String status);
}

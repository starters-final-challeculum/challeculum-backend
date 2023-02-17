package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.CreateGroundDto;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundLectureDto;

import java.util.List;
import java.util.Map;

public interface GroundService {
    void deleteGround(long groundId);

    Ground showGroundDetail(long groundId);

    List<GroundLectureDto> getGrounds(Integer page, Integer categoryId, Integer level);

    void createGround(CreateGroundDto createGroundDTO);

    List<Map<String, Object>> getMyGroundList(long userId, int page, String status);
}

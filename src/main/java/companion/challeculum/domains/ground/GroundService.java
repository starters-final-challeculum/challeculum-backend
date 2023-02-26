package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;
import companion.challeculum.domains.user.dtos.User;

import java.util.List;

public interface GroundService {
    Ground getGroundByGroundId(long groundId);
    void deleteGround(User user, long groundId);
    GroundJoined getGroundJoinedByGroundId(long groundId);
    List<GroundJoined> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword);
    List<GroundJoined> getGroundsByMe(long userId);
    List<GroundJoined> getMyGrounds(long userId);
    void createGround(User user, GroundCreateDto dto);
    void updateGround(long groundId, GroundUpdateDto groundUpdateDto);

}

package companion.challeculum.domains.ground;

import com.fasterxml.jackson.databind.ObjectMapper;
import companion.challeculum.common.Constants;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;
import companion.challeculum.domains.mission.MissionDao;
import companion.challeculum.domains.userground.UserGroundDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static companion.challeculum.common.Constants.ROWS_PER_PAGE;

@Service
@RequiredArgsConstructor
@Transactional
public class GroundServiceImpl implements GroundService {
    private final GroundDao groundDao;
    private final MissionDao missionDao;
    private final UserGroundDao userGroundDao;

    @Override
    public void deleteGround(long groundId) {
        Ground ground = groundDao.getGroundByGroundId(groundId);
        if (!ground.getStatus().equals(Constants.GROUND_STANDBY)) throw new RuntimeException(); // 에러 핸들링
        groundDao.deleteGround(groundId);
    }


    @Override
    public List<GroundJoined> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword) {
        Integer startRow = ROWS_PER_PAGE * (page - 1);
        Map<String, String> filterMap = new HashMap<>();
        String[] pairs = filter.split(",");
        Arrays.stream(pairs).filter(p -> !(p.equals(""))).forEach(p ->{
            String[] keyValue = p.split(":");
            if (!keyValue[1].equals("0") || !keyValue[1].equals("undefiend")) filterMap.put(keyValue[0], keyValue[1]);
        });
        return groundDao.getGroundList(startRow, ROWS_PER_PAGE, filterMap, sortBy, orderBy, keyword);

    }

    @Override
    public List<GroundJoined> getGroundsByMe(long userId) {
        return groundDao.getGroundsByMe(userId);
    }

    @Override
    public void updateGround(long groundId, GroundUpdateDto groundUpdateDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> updateMap = objectMapper.convertValue(groundUpdateDto, Map.class);
        Map<String, Object> newUpdatedMap = new HashMap<>();

        for (Map.Entry<String, Object> entry : updateMap.entrySet()) {
            String key = entry.getKey();
            String regex = "([a-z])([A-Z])";
            String replacement = "$1_$2";
            String newKey = key.replaceAll(regex, replacement).toLowerCase();
            newUpdatedMap.put(newKey, entry.getValue());
        }
        groundDao.update(groundId, newUpdatedMap);
    }

    @Override
    public List<GroundJoined> getMyGrounds(long userId) {
        return groundDao.getMyGrounds(userId);
    }

    //    Redesign(2/25)
    @Override
    public void createGround(GroundCreateDto dto) {
        long groundId = groundDao.insert(dto);
        dto.getMissionList().forEach(missionCreateDto -> {
            missionCreateDto.setGroundId(groundId);
            missionDao.insert(missionCreateDto);
        });
        userGroundDao.insert(dto.getCreateUserId(), groundId);
    }

    @Override
    public Ground getGroundByGroundId(long groundId) {
        return groundDao.getGroundByGroundId(groundId);
    }


    @Override
    public GroundJoined getGroundJoinedByGroundId(long groundId) {
        return groundDao.getGroundJoinedByGroundId(groundId);
    }
}

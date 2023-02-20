package companion.challeculum.domains.ground;

import com.fasterxml.jackson.databind.ObjectMapper;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;
import companion.challeculum.domains.mission.MissionDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    // ki young
    @Override
    public int getDepositById(long groundId) {
        int deposit=groundDao.getDepositById(groundId).getDeposit();
        return deposit;
    }
    // end of ki young

    @Override
    public void deleteGround(long groundId) {
        Ground ground = groundDao.getGround(groundId);
        if (ground == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 그라운드를 찾지 못했습니다.");
        }
        if (ground.getStatus().equals("cancelled")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 취소된 그라운드입니다.");
        }
        if (List.of("ongoing", "completed").contains(ground.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 시작한 그라운드 입니다.");
        }

        groundDao.refundDeposit(groundId);
        groundDao.markNotAttending(groundId);
        groundDao.deleteGround(groundId);
    }

    @Override
    public Ground getGround(long groundId) {
        return groundDao.getGround(groundId);
    }

    @Override
    public List<GroundJoined> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword) {
        Integer startRow = ROWS_PER_PAGE * (page - 1);
        Map<String, String> filterMap = new HashMap<>();
        String[] pairs = filter.split(",");
        Arrays.stream(pairs).filter(p -> !p.equals("")).forEach(p ->{
            String[] keyValue = p.split(":");
            filterMap.put(keyValue[0], keyValue[1]);
        });
        return groundDao.getGroundList(startRow, ROWS_PER_PAGE, filterMap, sortBy, orderBy, keyword);
    }

    @Override
    public List<Ground> getGroundsByMe(long userId) {
        return groundDao.getGroundsByMe(userId);
    }

    @Override
    public void createGround(GroundCreateDto groundCreateDTO) {
        groundDao.createGround(groundCreateDTO);
        missionDao.addMissionsToGround(groundCreateDTO.getMissionList());
    }

    @Override
    public List<Map<String,Object>> getMyGroundList(long userId, Integer page, String status) {
        final int ROWS_PER_PAGE = 7;
        Integer startRow = (page==null)? null:7 * (page - 1);
        System.out.println("===============================");
        System.out.println(groundDao.getMyGroundList(userId, startRow, ROWS_PER_PAGE, status));
        System.out.println("===============================");
        return groundDao.getMyGroundList(userId, startRow, ROWS_PER_PAGE, status);
    }

    @Override
    public int updateGround(long groundId, GroundUpdateDto groundUpdateDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> updateMap = objectMapper.convertValue(groundUpdateDto, Map.class);
        return groundDao.updateGround(groundId, updateMap);
    }

    @Override
    public Long getGroundCreator(long groundId) {
        return groundDao.getGroundCreator(groundId);
    }

    @Override
    public List<Map<String, Object>> getMyGrounds(long userId) {
        return groundDao.getMyGrounds(userId);
    }
}

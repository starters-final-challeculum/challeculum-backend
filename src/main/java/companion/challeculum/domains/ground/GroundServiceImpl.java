package companion.challeculum.domains.ground;

import com.fasterxml.jackson.databind.ObjectMapper;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;
import companion.challeculum.domains.mission.MissionDao;
import companion.challeculum.domains.userground.UserGroundDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class GroundServiceImpl implements GroundService {
    private final GroundDao groundDao;
    private final MissionDao missionDao;
    private final UserGroundDao userGroundDao;

    // ki young
    @Override
    public int getDepositById(long groundId) {
        int deposit = groundDao.getDepositById(groundId).getDeposit();
        return deposit;
    }

    // end of ki young

//    @Override
//    public void deleteGround(long groundId) {
//        Ground ground = groundDao.getGroundByGroundId(groundId);
//        if (ground == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 그라운드를 찾지 못했습니다.");
//        }
//        if (ground.get("status").equals("cancelled")) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 취소된 그라운드입니다.");
//        }
//        if (List.of("ongoing", "completed").contains(ground.get("status"))) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 시작한 그라운드 입니다.");
//        }
//
//        groundDao.refundDeposit(groundId);
//        groundDao.markNotAttending(groundId);
//        groundDao.deleteGround(groundId);
//    }


//    @Override
//    public List<Map<String, Object>> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword) {
//        Integer startRow = ROWS_PER_PAGE * (page - 1);
//        Map<String, String> filterMap = new HashMap<>();
//        String[] pairs = filter.split(",");
//        Arrays.stream(pairs).filter(p -> !(p.equals(""))).forEach(p ->{
//            String[] keyValue = p.split(":");
//            if (!keyValue[1].equals("0") || !keyValue[1].equals("undefiend")) filterMap.put(keyValue[0], keyValue[1]);
//        });
//        List<Map<String, Object>> groundList = groundDao.getGroundList(startRow, ROWS_PER_PAGE, filterMap, sortBy, orderBy, keyword);
//        return groundList;

//    }

    @Override
    public List<Map<String, Object>> getGroundsByMe(long userId) {
        return groundDao.getGroundsByMe(userId);
    }

    @Override
    public List<Map<String, Object>> getMyGroundList(long userId, Integer page, String status) {
        final int ROWS_PER_PAGE = 7;
        Integer startRow = (page == null) ? null : ROWS_PER_PAGE * (page - 1);
        System.out.println("===============================");
        System.out.println(groundDao.getMyGroundList(userId, startRow, ROWS_PER_PAGE, status));
        System.out.println("===============================");
        return groundDao.getMyGroundList(userId, startRow, ROWS_PER_PAGE, status);
    }

    @Override
    public int updateGround(long groundId, GroundUpdateDto groundUpdateDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> updateMap = objectMapper.convertValue(groundUpdateDto, Map.class);

        // create a new HashMap
        Map<String, Object> newUpdatedMap = new HashMap<>();

        // iterate over original map and put the key/values pair into a new one with modified key "two"
        for (Map.Entry<String, Object> entry : updateMap.entrySet()) {
            String key = entry.getKey();
            String regex = "([a-z])([A-Z])";
            String replacement = "$1_$2";
            String newKey = key.replaceAll(regex, replacement).toLowerCase();
            newUpdatedMap.put(newKey, entry.getValue());
        }
        System.out.println("======================");
        System.out.println(newUpdatedMap);
        System.out.println("======================");

        return groundDao.updateGround(groundId, newUpdatedMap);
    }

    @Override
    public Long getGroundCreator(long groundId) {
        return groundDao.getGroundCreator(groundId);
    }

    @Override
    public List<Map<String, Object>> getMyGrounds(long userId) {
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

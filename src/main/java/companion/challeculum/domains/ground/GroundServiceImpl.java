package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.CreateGroundDto;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundLectureDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class GroundServiceImpl implements GroundService {
    private final GroundDAO dao;

    @Override
    public void deleteGround(long groundId) {
        Ground ground = dao.showGroundDetail(groundId);
        if(ground == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 그라운드를 찾지 못했습니다.");
        }
        if(ground.getStatus().equals("cancelled")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 취소된 그라운드입니다.");
        }
        if(List.of("ongoing", "completed").contains(ground.getStatus())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 시작한 그라운드 입니다.");
        }

        dao.refundDeposit(groundId);
        dao.markNotAttending(groundId);
        dao.deleteGround(groundId);
    }

    @Override
    public Ground showGroundDetail(long groundId) {
        return dao.showGroundDetail(groundId);
    }

    @Override
    public List<GroundLectureDto> getGrounds(Integer page, Integer categoryId, Integer level) {
        // page1: 0-6
        // page2: 7-13
        // page3: 14-20
        // page4 : 21-27
        // page k :  7*( k - 1) ~ 7k-1
        final int ROWS_PER_PAGE = 7;
        Integer startRow = (page == null)? null:7 * (page - 1);

        return dao.getGrounds(startRow, ROWS_PER_PAGE, categoryId, level);
    }

    @Override
    public void createGround(CreateGroundDto createGroundDTO) {
        dao.createGround(createGroundDTO);
        dao.addMissionsToGround(createGroundDTO.getMissionList());
    }

    @Override
    public List<Map<String, Object>> getMyGroundList(long userId, int page, String status) {
        final int ROWS_PER_PAGE = 7;
        int startRow = 7 * (page - 1);
        return dao.getMyGrounds(userId, startRow, ROWS_PER_PAGE, status);
    }
}

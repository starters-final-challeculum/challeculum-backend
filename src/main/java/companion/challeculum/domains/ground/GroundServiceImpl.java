package companion.challeculum.domains.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service("groundservice")
@Transactional
public class GroundServiceImpl implements GroundService {
    @Autowired
    GroundDAO dao;

    @Override
    public void deleteGround(long groundId) {
        GroundDTO ground = dao.showGroundDetail(groundId);
        if(ground == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 그라운드를 찾지 못했습니다.");
        }
        if(ground.status.equals("cancelled")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 취소된 그라운드입니다.");
        }
        String[] CANT_DELETE_STATUSES = {"ongoing", "completed"};
        if(Arrays.asList(CANT_DELETE_STATUSES).contains(ground.status)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 시작한 그라운드 입니다.");
        }

        dao.refundDeposit(groundId);
        dao.markNotAttending(groundId);
        dao.deleteGround(groundId);
    }

    @Override
    public GroundDTO showGroundDetail(long groundId) {
        return dao.showGroundDetail(groundId);
    }

    @Override
    public List<GroundDTO> getGrounds(int page, Integer categoryId, Integer level) {
        // page1: 0-6
        // page2: 7-13
        // page3: 14-20
        // page4 : 21-27
        // page k :  7*( k - 1) ~ 7k-1
        final int ROWS_PER_PAGE = 7;
        int startRow = 7 * (page - 1);

        return dao.getGrounds(startRow, ROWS_PER_PAGE, categoryId, level);
    }

    @Override
    public void createGround(GroundDTO groundDTO) {
        dao.createGround(groundDTO);
    }

    @Override
    public List<Map<String, Object>> getMyGrounds(long userId, int page, String status) {
        final int ROWS_PER_PAGE = 7;
        int startRow = 7 * (page - 1);
        return dao.getMyGrounds(userId, startRow, ROWS_PER_PAGE, status);
    }
}

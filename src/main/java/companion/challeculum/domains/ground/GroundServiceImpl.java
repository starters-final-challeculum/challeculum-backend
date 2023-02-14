package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.exceptions.NoSuchGroundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("groundservice")
@Transactional
public class GroundServiceImpl implements GroundService{
    @Autowired
    GroundDAO dao;
    @Override
    public void deleteGround(long groundId){

        int numDeletedRow = dao.deleteGround(groundId);
        if(numDeletedRow == 0){
            throw new NoSuchGroundException();
        }

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
        int startRow = 7 * (page-1);

        return dao.getGrounds(startRow, ROWS_PER_PAGE, categoryId, level);
    }

    @Override
    public void createGround(GroundDTO groundDTO) {
        dao.createGround(groundDTO);
    }

    @Override
    public List<Map<String, Object>> getMyGrounds(long userId, int page, String status) {
        final int ROWS_PER_PAGE = 7;
        int startRow = 7 * (page-1);
        return dao.getMyGrounds(userId, startRow, ROWS_PER_PAGE, status);
    }
}

package companion.challeculum.domains.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("groundservice")
@Transactional
public class GroundServiceImpl implements GroundService{
    @Autowired
    GroundDAO dao;
    @Override
    public void deleteGround(long groundId){
        dao.deleteGround(groundId);
    }

    @Override
    public GroundDTO showGroundDetail(long groundId) {
        return dao.showGroundDetail(groundId);
    }

    @Override
    public List<GroundDTO> getGrounds(int page, Integer categoryId, Integer level) {
        return dao.getGrounds(page, categoryId, level);
    }
}

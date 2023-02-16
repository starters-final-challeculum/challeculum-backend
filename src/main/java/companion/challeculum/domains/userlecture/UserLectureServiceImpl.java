package companion.challeculum.domains.userlecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userlectureservice")
@Transactional
public class UserLectureServiceImpl implements  UserLectureService{

    @Autowired
    UserLectureDAO dao;

    @Override
    public void registerLecture(UserLectureDTO userLectureDTO) {
        dao.registerLecture(userLectureDTO);
    }
}

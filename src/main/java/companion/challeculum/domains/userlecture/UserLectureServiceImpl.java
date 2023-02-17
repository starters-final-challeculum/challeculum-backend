package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userlectureservice")
@Transactional
public class UserLectureServiceImpl implements UserLectureService {

    @Autowired
    UserLectureDao dao;

    @Override
    public void registerLecture(UserLecture userLecture) {
        dao.registerLecture(userLecture);
    }
}

package companion.challeculum.domains.user.services;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.user.dto.UserLecture;
import companion.challeculum.domains.user.dto.UserLectureJoined;
import companion.challeculum.domains.user.repositories.UserLectureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userlectureservice")
@RequiredArgsConstructor
@Transactional
public class UserLectureServiceImpl implements UserLectureService {
    private final UserLectureDao userLectureDao;
    private final AuthUserManager authUserManager;

    //유저가 듣고 있는 강의 등록
    @Override
    public void createUserLecture(long userId, long lectureId) {

        UserLecture userLecture = new UserLecture();
        userLecture.setUserId(userId);
        userLecture.setLectureId(lectureId);

        userLectureDao.createUserLecture(userLecture);
    }

    @Override
    public List<UserLectureJoined> getUserLectureJoinedList(long userId) {
        return userLectureDao.findUserLectureJoinedListByUserId(userId);
    }
}

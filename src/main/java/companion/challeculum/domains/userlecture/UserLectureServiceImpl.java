package companion.challeculum.domains.userlecture;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.userlecture.dtos.UserLecture;
import companion.challeculum.domains.userlecture.dtos.UserLectureJoined;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userlectureservice")
@RequiredArgsConstructor
@Transactional
public class UserLectureServiceImpl implements UserLectureService {

    private final UserLectureDao userLectureDao;

    private final AuthUserManager authUserManager;


    @Override
    public void createUserLecture(UserLecture userLecture) {
        userLectureDao.createUserLecture(userLecture);
    }

    @Override
    public List<UserLectureJoined> getUserLectureJoinedList(Authentication authentication) {
        return userLectureDao.findUserLectureJoinedListByUserId(authUserManager.getSessionId(authentication));
    }

    @Override
    public List<UserLectureJoined> getUserLectureJoinedList(long userId) {
        return userLectureDao.findUserLectureJoinedListByUserId(userId);
    }
}

package companion.challeculum.domains.userlecture;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.userlecture.dtos.UserLecture;
import companion.challeculum.domains.userlecture.dtos.UserLectureCreateDto;
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


    //유저가 듣고 있는 강의 등록
    @Override
    public void createUserLecture(UserLectureCreateDto userLectureCreateDto) {
        // 이미 등록한 강의 이면 등록하지 말고 return;

        int checkRegistered = userLectureDao.checkRegistered(userLectureCreateDto);

        if(checkRegistered == 0 )
        {
        userLectureDao.createUserLecture(userLectureCreateDto);
        }
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

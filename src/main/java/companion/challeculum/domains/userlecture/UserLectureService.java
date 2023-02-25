package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import companion.challeculum.domains.userlecture.dtos.UserLectureJoined;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface UserLectureService {

    void createUserLecture(UserLecture userLecture);
    List<UserLectureJoined> getUserLectureJoinedList(Authentication authentication);
    List<UserLectureJoined> getUserLectureJoinedList(long userId);
}

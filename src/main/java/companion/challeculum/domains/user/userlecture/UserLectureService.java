package companion.challeculum.domains.user.userlecture;

import companion.challeculum.domains.user.userlecture.dtos.UserLectureJoined;

import java.util.List;

public interface UserLectureService {

    void createUserLecture(long userId, long lectureId);
    List<UserLectureJoined> getUserLectureJoinedList(long userId);
}

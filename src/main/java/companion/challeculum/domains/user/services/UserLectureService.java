package companion.challeculum.domains.user.services;

import companion.challeculum.domains.user.dto.UserLectureJoined;

import java.util.List;

public interface UserLectureService {

    void createUserLecture(long userId, long lectureId);

    List<UserLectureJoined> getUserLectureJoinedList(long userId);
}

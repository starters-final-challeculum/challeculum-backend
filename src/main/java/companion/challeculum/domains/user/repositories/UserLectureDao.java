package companion.challeculum.domains.user.repositories;

import companion.challeculum.domains.user.dto.UserLecture;
import companion.challeculum.domains.user.dto.UserLectureJoined;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLectureDao {
    void createUserLecture(UserLecture userLecture);

    List<UserLectureJoined> findUserLectureJoinedListByUserId(Long userId);

    UserLecture findUserLecture(long userId, long lectureId);
}

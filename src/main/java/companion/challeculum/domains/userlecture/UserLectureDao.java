package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import companion.challeculum.domains.userlecture.dtos.UserLectureCreateDto;
import companion.challeculum.domains.userlecture.dtos.UserLectureJoined;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLectureDao {

    void createUserLecture(UserLectureCreateDto userLectureCreateDto);

    int checkRegistered(UserLectureCreateDto userLectureCreateDto);

    UserLecture findUserLecture(long userId, long lectureId);

    List<UserLectureJoined> findUserLectureJoinedListByUserId(Long userId);
}

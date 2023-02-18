package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLectureDao {

    void registerLecture(UserLecture userLecture);
    UserLecture findUserLecture(long userId, long lectureId);
}

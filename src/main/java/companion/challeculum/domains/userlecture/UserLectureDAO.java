package companion.challeculum.domains.userlecture;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLectureDAO {

    void registerLecture(UserLectureDTO userLectureDTO);
}

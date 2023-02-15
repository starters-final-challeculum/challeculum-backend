package companion.challeculum.domains.lecture;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LectureDAO {
    void addLecture(LectureDTO lectureDTO);

    void modifyLecture(LectureDTO lectureDTO);
}

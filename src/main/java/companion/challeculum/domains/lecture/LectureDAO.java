package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LectureDAO {
    void addLecture(Lecture lecture);

    void modifyLecture(Lecture lecture);
}

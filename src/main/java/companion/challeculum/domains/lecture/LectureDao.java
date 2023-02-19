package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LectureDao {
    void addLecture(Lecture lecture);

    void modifyLecture(Lecture lecture);
    List<Lecture> getLectureList(@Param("startRow") Integer startRow,
                                 @Param("limit") int limit,
                                 @Param("filterMap") Map<String, String> filterMap,
                                 @Param("keyword") String keyword);
}

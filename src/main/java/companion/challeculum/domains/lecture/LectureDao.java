package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.lecture.dtos.LectureCreateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LectureDao {
    void createLecture(LectureCreateDto lectureCreateDto);

    void updateLecture(Lecture lecture);
    List<Lecture> getLectureList(@Param("startRow") Integer startRow,
                                 @Param("limit") int limit,
                                 @Param("filterMap") Map<String, String> filterMap,
                                 @Param("keyword") String keyword);

    List<Lecture> getLectureListAvailable(long userId ,
                                          @Param("startRow") Integer startRow,
                                          @Param("limit") int limit,
                                          @Param("filterMap") Map<String, String> filterMap,
                                          @Param("keyword") String keyword);
}

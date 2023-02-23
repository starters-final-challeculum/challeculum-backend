package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.lecture.dtos.LectureCreateDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface LectureService {


    void createLecture(LectureCreateDto lectureCreateDto);

    void updateLecture(Lecture lecture);

    List<Lecture> getLectureList(int page, String filter, String keyword);

    List<Lecture> getLectureListAvailable(Authentication authentication, int page, String filter, String keyword);
}

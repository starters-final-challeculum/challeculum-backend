package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.lecture.dtos.LectureCreateDto;

import java.util.List;

public interface LectureService {


    void createLecture(LectureCreateDto lectureCreateDto);

    void updateLecture(Lecture lecture);

    List<Lecture> getLectureList(int page, String filter, String keyword);
}

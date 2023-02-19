package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;

import java.util.List;

public interface LectureService {


    void addLecture(Lecture lecture);

    void modifyLecture(Lecture lecture);

    List<Lecture> getLectureList(int page, String filter, String keyword);
}

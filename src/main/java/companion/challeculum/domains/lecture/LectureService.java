package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;

public interface LectureService {


    void addLecture(Lecture lecture);

    void modifyLecture(Lecture lecture);
}

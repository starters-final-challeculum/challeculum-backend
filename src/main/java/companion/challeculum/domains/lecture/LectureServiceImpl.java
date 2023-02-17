package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("lectureservice")
@Transactional
@RequiredArgsConstructor
public class LectureServiceImpl implements  LectureService{
    private final LectureDAO dao;

    @Override
    public void addLecture(Lecture lecture) {
        dao.addLecture(lecture);
    }

    @Override
    public void modifyLecture(Lecture lecture) {
        dao.modifyLecture(lecture);
    }
}

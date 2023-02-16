package companion.challeculum.domains.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("lectureservice")
@Transactional
//@RequiredArgsConstructor
public class LectureServiceImpl implements  LectureService{

    @Autowired
    LectureDAO dao;

    @Override
    public void addLecture(LectureDTO lectureDTO) {
        dao.addLecture(lectureDTO);
    }

    @Override
    public void modifyLecture(LectureDTO lectureDTO) {
        dao.modifyLecture(lectureDTO);
    }
}

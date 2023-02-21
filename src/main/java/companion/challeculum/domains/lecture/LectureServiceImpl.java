package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.lecture.dtos.LectureCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static companion.challeculum.common.Constants.ROWS_PER_PAGE;

@Service("lectureservice")
@Transactional
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureDao lectureDao;

    @Override
    public void createLecture(LectureCreateDto lectureCreateDto) {

        lectureDao.createLecture(lectureCreateDto);
        System.out.println();
    }

    @Override
    public void updateLecture(Lecture lecture) {
        lectureDao.updateLecture(lecture);
    }

    @Override
    public List<Lecture> getLectureList(int page, String filter, String keyword) {
        Integer startRow = ROWS_PER_PAGE * (page - 1);
        Map<String, String> filterMap = new HashMap<>();
        if(filter != null) {
            String[] pairs = filter.split(",");

            Arrays.stream(pairs).filter(p -> !p.equals("")).forEach(p ->{
                String[] keyValue = p.split(":");
                filterMap.put(keyValue[0], keyValue[1]);
            });
        }

        return lectureDao.getLectureList(startRow, ROWS_PER_PAGE, filterMap, keyword);
    }
}

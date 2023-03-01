package companion.challeculum.domains.lecture;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.lecture.dto.Lecture;
import companion.challeculum.domains.lecture.dto.LectureCreateDto;
import companion.challeculum.domains.user.dto.UserLectureJoined;
import companion.challeculum.domains.user.repositories.UserLectureDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
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
    private final UserLectureDao userLectureDao;
    private final AuthUserManager authUserManager;

    //admin이 강의 추가
    @Override
    public void createLecture(LectureCreateDto lectureCreateDto) {
        lectureDao.createLecture(lectureCreateDto);
    }

    //admin이 강의 수정
    @Override
    public void updateLecture(Lecture lecture) {
        lectureDao.updateLecture(lecture);
    }

    @Override
    public List<Lecture> getLectureList(int page, String filter, String keyword) {
        Integer startRow = ROWS_PER_PAGE * (page - 1);
        Map<String, String> filterMap = new HashMap<>();
        if (filter != null) {
            String[] pairs = filter.split(",");
            Arrays.stream(pairs).filter(p -> !p.equals("")).forEach(p -> {
                String[] keyValue = p.split(":");
                filterMap.put(keyValue[0], keyValue[1]);
            });
        }

        return lectureDao.getLectureList(startRow, ROWS_PER_PAGE, filterMap, keyword);
    }

    @Override
    public List<Lecture> getLectureListAvailable(Authentication authentication, int page, String filter, String keyword) {
        Integer startRow = ROWS_PER_PAGE * (page - 1);
        Map<String, String> filterMap = new HashMap<>();
        if (filter != null) {
            String[] pairs = filter.split(",");

            Arrays.stream(pairs).filter(p -> !p.equals("")).forEach(p -> {
                String[] keyValue = p.split(":");
                filterMap.put(keyValue[0], keyValue[1]);
            });
        }

        long userId = authUserManager.getSessionId(authentication);

        List<Lecture> tempLecture = lectureDao.getLectureListAvailable(userId, startRow, ROWS_PER_PAGE, filterMap, keyword);
        List<UserLectureJoined> tempUserLecture = userLectureDao.findUserLectureJoinedListByUserId(userId);

        System.out.println(tempLecture);
        System.out.println(tempUserLecture);

        for (int i = 0; i < tempLecture.size(); i++) {
            for (UserLectureJoined userLectureJoined : tempUserLecture) {
                if (tempLecture.get(i).getLectureId() == userLectureJoined.getLectureId()) {
                    tempLecture.remove(i);
                }
            }
        }

        return tempLecture;

    }
}

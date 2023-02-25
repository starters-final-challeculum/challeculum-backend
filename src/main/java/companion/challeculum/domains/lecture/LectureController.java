package companion.challeculum.domains.lecture;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.lecture.dtos.LectureCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;
    private final AuthUserManager authUserManager;

    //lecture 추가
    @PostMapping
    void createLecture(@ModelAttribute LectureCreateDto lectureCreateDto) {
        lectureService.createLecture(lectureCreateDto);
    }

    //lecture 수정
    @PatchMapping
    void updateLecture(@ModelAttribute Lecture lecture) {

        lectureService.updateLecture(lecture);
    }

    //search한 강의 목록 조회
    @GetMapping
    List<Lecture> getLectureList(@RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false) String filter,
                                 @RequestParam(required = false) String keyword){
        return lectureService.getLectureList(page, filter, keyword);
    }

    //search한 강의 목록 조회 ( 내가 등록한 lecture는 제외)
    @GetMapping("/available")
    List<Lecture> getLectureListAvailable(Authentication authentication,
                                 @RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false) String filter,
                                 @RequestParam(required = false) String keyword){

        return lectureService.getLectureListAvailable(authentication, page, filter, keyword);
    }





}

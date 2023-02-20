package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import companion.challeculum.domains.lecture.dtos.LectureCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    //lecture 추가
    @PostMapping
    void createLecture(@ModelAttribute LectureCreateDto lectureCreateDto) {
        lectureService.createLecture(lectureCreateDto);
    }

    @GetMapping
    List<Lecture> getLectureList(@RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false) String filter,
                                 @RequestParam(required = false) String keyword){
        return lectureService.getLectureList(page, filter, keyword);
    }

    //lecture 수정
    @PatchMapping
    void updateLecture(@ModelAttribute Lecture lecture) {
        lectureService.updateLecture(lecture);
    }


}

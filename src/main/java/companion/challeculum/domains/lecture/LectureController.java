package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    void addLecture(@ModelAttribute Lecture lecture) {
        lectureService.addLecture(lecture);
    }

    @GetMapping
    List<Lecture> getLectureList(@RequestParam(required = false, defaultValue = "1") int page,
                                 @RequestParam(required = false) String filter,
                                 @RequestParam(required = false) String keyword){
        return lectureService.getLectureList(page, filter, keyword);
    }

    @PatchMapping("/lecture")
    void modifyLecture(@ModelAttribute Lecture lecture) {
        lectureService.modifyLecture(lecture);
    }


}

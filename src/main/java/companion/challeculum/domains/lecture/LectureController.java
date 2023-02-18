package companion.challeculum.domains.lecture;

import companion.challeculum.domains.lecture.dtos.Lecture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping("/lecture")
    void addLecture(@ModelAttribute Lecture lecture) {
        lectureService.addLecture(lecture);
    }

    @GetMapping("/api/v1/lecture")
    List<Lecture> getLectureList(@RequestParam int page,
                                 @RequestParam String filter,
                                 @RequestParam String keyword){
        return null;
    }

    @PatchMapping("/lecture")
    void modifyLecture(@ModelAttribute Lecture lecture) {
        lectureService.modifyLecture(lecture);
    }


}

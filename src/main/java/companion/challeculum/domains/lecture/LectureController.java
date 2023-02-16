package companion.challeculum.domains.lecture;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LectureController {


    private final LectureService lectureService;


    @PostMapping("/lecture")
    void addLecture(@ModelAttribute LectureDTO lectureDTO){
        lectureService.addLecture(lectureDTO);
    }

    @PatchMapping("/lecture")
    void modifyLecture(@ModelAttribute LectureDTO lectureDTO){
        lectureService.modifyLecture(lectureDTO);
    }


}

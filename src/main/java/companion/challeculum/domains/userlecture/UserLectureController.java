package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserLectureController {

    private final UserLectureService userLectureService;

    @PostMapping("/userlecture")
    void registerLecture(@ModelAttribute UserLecture userLecture) {
        userLectureService.registerLecture(userLecture);
    }


}

package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserLectureController {

    private final UserLectureService userLectureService;

    @GetMapping("/api/v1/userlecture")
    List<UserLecture> getMyLectureList(Authentication authentication){
        return null;
    }

    @PostMapping("/userlecture")
    void registerLecture(@ModelAttribute UserLecture userLecture) {
        userLectureService.registerLecture(userLecture);
    }


}

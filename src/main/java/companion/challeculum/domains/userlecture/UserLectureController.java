package companion.challeculum.domains.userlecture;

import companion.challeculum.domains.userlecture.dtos.UserLecture;
import companion.challeculum.domains.userlecture.dtos.UserLectureJoined;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userlecture")
@RequiredArgsConstructor
public class UserLectureController {

    private final UserLectureService userLectureService;

    @GetMapping
    public List<UserLectureJoined> getMyLectureList(Authentication authentication){
        return userLectureService.getUserLectureJoinedList(authentication);
    }

    @GetMapping("/{userId}")
    public List<UserLectureJoined> getUserLectureList(@PathVariable long userId){
        return userLectureService.getUserLectureJoinedList(userId);
    }

    @PostMapping
    public void registerLecture(@ModelAttribute UserLecture userLecture) {
        userLectureService.createUserLecture(userLecture);
    }
}

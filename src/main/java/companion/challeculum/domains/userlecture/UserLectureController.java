package companion.challeculum.domains.userlecture;

import companion.challeculum.common.AuthUserManager;
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
    private final AuthUserManager authUserManager;

    //유저가 등록한 강의 목록
    @GetMapping
    public List<UserLectureJoined> getMyLectureList(Authentication authentication){
        return userLectureService.getUserLectureJoinedList(authentication);
    }

    @GetMapping("/{userId}")
    public List<UserLectureJoined> getUserLectureList(@PathVariable long userId){
        return userLectureService.getUserLectureJoinedList(userId);
    }

    //유저 강의 등록
    @PostMapping("/{lectureId}")
    public void createUserLecture(Authentication authentication, @PathVariable long lectureId) {
        userLectureService.createUserLecture(authUserManager.getSessionId(authentication) ,lectureId);
    }


}
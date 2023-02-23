package companion.challeculum.domains.userlecture;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.userlecture.dtos.UserLecture;
import companion.challeculum.domains.userlecture.dtos.UserLectureCreateDto;
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

    @GetMapping
    public List<UserLectureJoined> getMyLectureList(Authentication authentication){
        return userLectureService.getUserLectureJoinedList(authentication);
    }

    @GetMapping("/{userId}")
    public List<UserLectureJoined> getUserLectureList(@PathVariable long userId){
        return userLectureService.getUserLectureJoinedList(userId);
    }

    //유저가 듣고 있는 강의 등록
    @PostMapping("/{lectureId}")
    public void createUserLecture(Authentication authentication, @PathVariable long lectureId) {
        UserLectureCreateDto userLectureCreateDto = new UserLectureCreateDto();
        long userId = authUserManager.getSessionId(authentication);
        userLectureCreateDto.setUserId(userId);
        userLectureCreateDto.setLectureId(lectureId);
        userLectureService.createUserLecture(userLectureCreateDto);
    }


}
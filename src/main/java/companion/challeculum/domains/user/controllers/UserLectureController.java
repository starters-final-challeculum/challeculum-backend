package companion.challeculum.domains.user.controllers;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.user.dto.UserLectureJoined;
import companion.challeculum.domains.user.services.UserLectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
@RequestMapping("/api/v1/user")
public class UserLectureController {

    private final UserLectureService userLectureService;
    private final AuthUserManager authUserManager;

    //로그인 유저가 등록한 강의 목록
    @GetMapping("/me/lecture")
    public List<UserLectureJoined> getMyLectureList(Authentication authentication) {
        return userLectureService.getUserLectureJoinedList(authUserManager.getSessionId(authentication));
    }

    //유저가 등록한 강의목록(현재 사용안함)
    @GetMapping("/{userId}/lecture")
    public List<UserLectureJoined> getUserLectureList(@PathVariable long userId) {
        return userLectureService.getUserLectureJoinedList(userId);
    }

    //로그인 유저 강의 등록
    @PostMapping("me/lecture/{lectureId}")
    public void createUserLecture(Authentication authentication, @PathVariable long lectureId) {
        userLectureService.createUserLecture(authUserManager.getSessionId(authentication), lectureId);
    }

}
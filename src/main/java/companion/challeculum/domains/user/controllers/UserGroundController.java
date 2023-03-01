package companion.challeculum.domains.user.controllers;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.common.Constants;
import companion.challeculum.domains.user.dto.Review;
import companion.challeculum.domains.user.dto.UserGroundJoined;
import companion.challeculum.domains.user.services.UserGroundService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
@RequestMapping("/api/v1/user")
public class UserGroundController {
    private final UserGroundService userGroundService;
    private final AuthUserManager authUserManager;

    // 그라운드 참여 (그라운드 상세 페이지)
    @PostMapping("/me/ground/{groundId}")
    void createUserGround(Authentication authentication, @PathVariable long groundId) {
        userGroundService.createUserGround(authUserManager.getMe(authentication), groundId);
    }

    //그라운드 참여 취소 (프로필, 그라운드 상세 페이지)
    @DeleteMapping("/me/ground/{groundId}")
    void deleteUserGround(Authentication authentication, @PathVariable long groundId) {
        userGroundService.deleteUserGround(authUserManager.getMe(authentication), groundId);
    }

    // 내 그라운드 리스트(상태별 조회) (메인페이지, 프로필 페이지)
    @GetMapping("/me/ground")
    List<UserGroundJoined> getMyUserGroundList(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = Constants.GROUND_ONGOING) String status,
            Authentication authentication) {
        return userGroundService.getMyGroundList(authUserManager.getSessionId(authentication), page, status);
    }

    // 참여 가능한 그라운드 인지 여부 확인 (그라운드 상세 페이지 STANDBY)
    @GetMapping("/me/ground/{groundId}/available")
    boolean isAvailableGround(Authentication authentication, @PathVariable long groundId) {
        return userGroundService.isAvailableGround(authUserManager.getSessionId(authentication), groundId);
    }

    // 그라운드 리뷰 작성 (그라운드 상세 페이지 COMPLETED)
    @PostMapping("/me/ground/{groundId}/review")
    void reviewUserGround(Authentication authentication,
                          @PathVariable long groundId,
                          @RequestBody Review review) {
        long userId = authUserManager.getSessionId(authentication);
        userGroundService.createReview(userId, groundId, review);
    }

    // 그라운드 리뷰 작성 가능 여부(그라운드 참여한 유저만 가능)(그라운드 상세 페이지 COMPLETED)
    @GetMapping("/me/ground/{groundId}/review/available")
    boolean isReviewAvailable(Authentication authentication, @PathVariable long groundId) {
        return userGroundService.isReviewAvailable(groundId, authUserManager.getSessionId(authentication));
    }
}

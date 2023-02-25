package companion.challeculum.domains.userground;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.common.Constants;
import companion.challeculum.domains.user.dtos.UserInfoDto;
import companion.challeculum.domains.userground.dtos.Review;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserGroundController {
    private final UserGroundService userGroundService;
    private final AuthUserManager authUserManager;

    // 그라운드 참여 (그라운드 생성 페이지)
    @PostMapping("/api/v1/userground/{groundId}")
    void createUserGround(Authentication authentication, @PathVariable long groundId) {
        userGroundService.createUserGround(authUserManager.getMe(authentication), groundId);
    }

    //그라운드 참여 취소 (프로필, 그라운드 상세 페이지)
    @DeleteMapping("/api/v1/userground/{groundId}")
    void deleteUserGround(Authentication authentication, @PathVariable long groundId) {
        userGroundService.deleteUserGround(authUserManager.getMe(authentication), groundId);
    }

    // 내 그라운드 리스트(상태별 조회) (메인페이지, 프로필 페이지)
    @GetMapping("/api/v1/userground")
    List<UserGroundJoined> getMyUserGroundList(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = Constants.GROUND_ONGOING) String status,
            Authentication authentication) {
        return userGroundService.getMyGroundList( authUserManager.getSessionId(authentication), page, status);
    }

    // 그라운드 예상 획득 금액 (그라운드 상세 페이지)
    @GetMapping("/api/v1/userground/{groundId}/reward")
    String getReward(@PathVariable long groundId) {
        return userGroundService.getReward(groundId);
    }

    // 그라운드 성공 유저 리스트 (그라운드 상세 페이지)
    @GetMapping("/api/v1/userground/{groundId}/success")
    List<UserInfoDto> getSuccessUserList(@PathVariable long groundId) {
        return userGroundService.getSuccessUserList(groundId);
    }

    // 그라운드에 참여한 유저 리스트 (그라운드 상세 페이지)
    @GetMapping("/api/v1/userground/{groundId}")
    List<UserInfoDto> getUsergroundList(Authentication authentication, @PathVariable long groundId) {
        return userGroundService.getUserGroundList(authUserManager.getSessionId(authentication), groundId);
    }

    // 그라운드의 리뷰 리스트 (그라운드 상세 페이지 COMPLETED)
    @GetMapping("/api/v1/userground/{groundId}/review")
    List<Review> getReviewList(@PathVariable long groundId){
        return userGroundService.getReviewList(groundId);
    }

    // 참여 가능한 그라운드 인지 여부 확인 (그라운드 상세 페이지 STANDBY)
    @GetMapping("/api/v1/userground/available/{groundId}")
    boolean isAvailableGround(Authentication authentication, @PathVariable long groundId){
        return userGroundService.isAvailableGround(authUserManager.getSessionId(authentication), groundId);
    }

    // 그라운드 리뷰 작성 가능 여부(그라운드 참여한 유저만 가능)(그라운드 상세 페이지 COMPLETED)
    @GetMapping("/api/v1/userground/{groundId}/review-available")
    boolean isReviewAvailable(Authentication authentication, @PathVariable long groundId) {
        return userGroundService.isReviewAvailable(groundId, authUserManager.getSessionId(authentication));
    }

    // 그라운드 리뷰 작성 (그라운드 상세 페이지 COMPLETED)
    @PostMapping("/api/v1/userground/{groundId}/review")
    void reviewUserGround(Authentication authentication,
                         @PathVariable long groundId,
                         @RequestBody Review review) {
        long userId = authUserManager.getSessionId(authentication);
        userGroundService.createReview(userId, groundId, review);
    }
}

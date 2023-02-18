package companion.challeculum.domains.userground;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.ground.GroundService;
import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import companion.challeculum.security.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserGroundController {
    private final UserGroundService userGroundService;
    private final GroundService groundService;
    private final AuthUserManager authUserManager;

    //그라운드 참여 취소
    @PatchMapping("/api/v1/userground/{groundId}")
    void changeUserGround(Authentication authentication,
                          @PathVariable long groundId) {
        userGroundService.cancelParticipateGround(groundId, authUserManager.getSessionId(authentication));
    }

    //그라운드 참여
    @PostMapping("/api/v1/userground/{groundId}")
    void createUserGround(Authentication authentication,
                          @PathVariable long groundId) {
        userGroundService.participateGround(groundId, authUserManager.getSessionId(authentication));
    }

    @GetMapping("/api/v1/userground")
    List<Map<String, Object>> getMyUserGroundList(@RequestParam int page,
                                                  @RequestParam(required = false) String status,
                                                  Authentication authentication) {
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }
        long sessUserId = ((PrincipalDetails) authentication.getPrincipal()).getUser().getId();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if (!hasAdminRole) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "본인이나 관리자만 확인 가능합니다.");
        }
        return groundService.getMyGroundList(authUserManager.getSessionId(authentication), page, status);
    }

    @GetMapping("/api/v1/userground/reward/{groundId}")
    int getReward(@PathVariable long groundId){
        return 0;
    }

    @GetMapping("/api/v1/userground/success/{groundId}")
    List<UserGroundJoined> getSuccessUserList(@PathVariable long groundId){
        return null;
    }

    @GetMapping("/api/v1/userground/{groundId}")
    List<UserGroundJoined> getUsergroundList(Authentication authentication,
                                             @PathVariable long groundId){
        return null;
    }

    @GetMapping("/api/v1/userground/review/{groundId}")
    List<UserGround> getUserGroundReviewList(@PathVariable long groundId){
        return null;
    }

    @GetMapping("/api/v1/userground/available/{groundId}")
    boolean isAvailableGround(Authentication authentication,
                              @PathVariable long groundId){
        return true; // or false
    }

    @GetMapping("/api/v1/userground/review-available/{groundId}")
    boolean isReviewAvailable(Authentication authentication,
                              @PathVariable long groundId){
        return true;
    }

    @PatchMapping("/api/v1/userground/review/{groundId}")
    void reviewUserGround(Authentication authentication,
                     @PathVariable long groundId){

    }
}

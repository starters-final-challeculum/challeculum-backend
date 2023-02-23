package companion.challeculum.domains.userground;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.ground.GroundService;
import companion.challeculum.domains.userground.dtos.UserGround;
import companion.challeculum.domains.userground.dtos.UserGroundJoined;
import companion.challeculum.domains.userground.dtos.UserGroundUpdateDto;
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


    //그라운드 참여
    @PostMapping("/api/v1/userground/{groundId}")
    void createUserGround(Authentication authentication,
                          @PathVariable long groundId) {
        long userId = authUserManager.getSessionId(authentication);
        userGroundService.createUserGround(groundId, userId);
    }

    //그라운드 참여 취소
    @PatchMapping("/api/v1/userground/{groundId}")
    void changeUserGround(Authentication authentication,
                          @PathVariable long groundId) {
        long userId = authUserManager.getSessionId(authentication);
        userGroundService.changeUserGround(groundId, userId);
    }



    @GetMapping("/api/v1/userground")
    List<Map<String,Object>> getMyUserGroundList(@RequestParam(required = false) Integer page,
                                                   @RequestParam(required = false, defaultValue = "ongoing") String status,
                                                   Authentication authentication) {
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }

        long userId = authUserManager.getSessionId(authentication);

        return groundService.getMyGroundList(userId, page, status);
    }

    @GetMapping("/api/v1/userground/reward/{groundId}")
    int getReward(@PathVariable long groundId){
        int Reward= userGroundService.getReward(groundId);
        return Reward;
    }

    @GetMapping("/api/v1/userground/success/{groundId}")
    List<UserGroundJoined> getSuccessUserList(@PathVariable long groundId){
        return userGroundService.getSuccessUserList(groundId);
    }

    @GetMapping("/api/v1/userground/{groundId}")
    List<UserGroundJoined> getUsergroundList(Authentication authentication,
                                             @PathVariable long groundId){
        if(authentication == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인 하세요.");
        }
        long userId = authUserManager.getSessionId(authentication);
        return userGroundService.getUserGroundList(userId, groundId);
    }

    @GetMapping("/api/v1/userground/review/{groundId}")
    List<UserGround> getUserGroundReviewList(@PathVariable long groundId){
        return userGroundService.getUserGroundReviewList(groundId);
    }

    @GetMapping("/api/v1/userground/available/{groundId}")
    boolean isAvailableGround(Authentication authentication, @PathVariable long groundId){
        return userGroundService.isAvailableGround(authUserManager.getSessionId(authentication), groundId);
    }

    @GetMapping("/api/v1/userground/review-available/{groundId}")
    boolean isReviewAvailable(Authentication authentication,
                              @PathVariable long groundId){
        boolean isReviewAvaialable=
                userGroundService.isReviewAvailable(groundId, authUserManager.getSessionId(authentication));
        return isReviewAvaialable;
    }

    @PatchMapping("/api/v1/userground/review/{groundId}")
    int reviewUserGround(Authentication authentication,
                          @PathVariable long groundId,
                          @RequestBody UserGroundUpdateDto userGroundUpdateDto){
        if(authentication == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인 하세요.");
        }
        long userId = authUserManager.getSessionId(authentication);
        return userGroundService.reviewUserGround(userId, groundId, userGroundUpdateDto);
    }
}

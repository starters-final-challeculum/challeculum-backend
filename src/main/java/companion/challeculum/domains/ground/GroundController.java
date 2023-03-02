package companion.challeculum.domains.ground;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.common.Constants;
import companion.challeculum.domains.ground.dto.GroundCreateDto;
import companion.challeculum.domains.ground.dto.GroundJoined;
import companion.challeculum.domains.ground.dto.GroundUpdateDto;
import companion.challeculum.domains.user.dto.Review;
import companion.challeculum.domains.user.dto.UserInfoDto;
import companion.challeculum.domains.user.services.UserGroundService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ground")
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;
    private final UserGroundService userGroundService;
    private final AuthUserManager authUserManager;

    // 그라운드 생성 (그라운드 생성 페이지)
    @PostMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    void createGround(@RequestBody GroundCreateDto groundCreateDto, Authentication authentication) {

        groundService.createGround(authUserManager.getMe(authentication), groundCreateDto);
    }

    // 그라운드 리스트 조회(검색) (메인페이지 (로그인, 비로그인))
    @GetMapping
    List<GroundJoined> getGroundList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                     @RequestParam(required = false, defaultValue = "") String filter,
                                     @RequestParam(required = false, defaultValue = "asc") String sortBy,
                                     @RequestParam(required = false, defaultValue = "created_at") String orderBy,
                                     @RequestParam(required = false) String keyword) {
        return groundService.getGroundList(page, filter, sortBy, orderBy, keyword);
    }

    // 내가 생성한 그라운드(프로필 페이지)
    @GetMapping("/byme")
    @PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
    List<GroundJoined> getGroundsByMe(Authentication authentication) {
        return groundService.getGroundsByMe(authUserManager.getSessionId(authentication));
    }

    // 그라운드 상세 조회 (그라운드 그라운드 상세 페이지)
    @GetMapping("/{groundId}")
    GroundJoined getGround(@PathVariable long groundId) {
        return groundService.getGroundJoinedByGroundId(groundId);
    }

    // 내가 참여하는 그라운드(프로필 페이지)
    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
    List<GroundJoined> getMyGrounds(Authentication authentication
            , @RequestParam(name = "status", required = false, defaultValue = Constants.GROUND_ONGOING) String status) {
        return groundService.getMyGrounds(authUserManager.getSessionId(authentication), status);
    }

    // 그라운드 삭제(프로필 페이지, 어드민 페이지, 그라운드 상세 페이지)
    @DeleteMapping("/{groundId}")
    @PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
    void deleteGround(@PathVariable long groundId, Authentication authentication) {
        groundService.deleteGround(authUserManager.getMe(authentication), groundId);
    }

    // 그라운드 업데이트(그라운드 업데이트 페이지?)
    @PatchMapping("/{groundId}")
    @PreAuthorize("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')")
    void updateGround(@PathVariable long groundId,
                      @RequestBody GroundUpdateDto groundUpdateDto) {
        groundService.updateGround(groundId, groundUpdateDto);
    }

    // 그라운드 예상 획득 금액 (그라운드 상세 페이지)
    @GetMapping("/{groundId}/reward")
    String getReward(@PathVariable long groundId) {
        return userGroundService.getReward(groundId);
    }

    // 그라운드 성공 유저 리스트 (그라운드 상세 페이지)
    @GetMapping("/{groundId}/user/success")
    List<UserInfoDto> getSuccessUserList(@PathVariable long groundId) {
        return userGroundService.getSuccessUserList(groundId);
    }

    // 그라운드에 참여한 유저 리스트 (그라운드 상세 페이지)
    @GetMapping("/{groundId}/user")
    List<UserInfoDto> getUsergroundList(@PathVariable long groundId) {
        return userGroundService.getUserGroundList(groundId);
    }

    // 그라운드의 리뷰 리스트 (그라운드 상세 페이지 COMPLETED)
    @GetMapping("/{groundId}/review")
    List<Review> getReviewList(@PathVariable long groundId) {
        return userGroundService.getReviewList(groundId);
    }
}

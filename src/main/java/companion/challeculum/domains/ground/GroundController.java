package companion.challeculum.domains.ground;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;
    private final AuthUserManager authUserManager;
    // 그라운드 생성 (그라운드 생성 페이지)
    @PostMapping("/api/v1/ground")
    void createGround(@RequestBody GroundCreateDto groundCreateDto, Authentication authentication) {
        groundService.createGround(authUserManager.getMe(authentication), groundCreateDto);
    }

    // 그라운드 리스트 조회(검색) (메인페이지 (로그인, 비로그인))
    @GetMapping("/api/v1/ground")
    List<GroundJoined> getGroundList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                     @RequestParam(required = false, defaultValue = "") String filter,
                                     @RequestParam(required = false, defaultValue = "asc") String sortBy,
                                     @RequestParam(required = false, defaultValue = "created_at") String orderBy,
                                     @RequestParam(required = false) String keyword) {
        return groundService.getGroundList(page, filter, sortBy, orderBy, keyword);
    }

    // 내가 생성한 그라운드(프로필 페이지)
    @GetMapping("/api/v1/ground/byme")
    List<GroundJoined> getGroundsByMe(Authentication authentication) {
        return groundService.getGroundsByMe(authUserManager.getSessionId(authentication));
    }

    // 그라운드 상세 조회 (그라운드 그라운드 상세 페이지)
    @GetMapping("/api/v1/ground/{groundId}")
    GroundJoined getGround(@PathVariable long groundId) {
        return groundService.getGroundJoinedByGroundId(groundId);
    }

    // 내가 참여하는 그라운드(프로필 페이지)
    @GetMapping("/api/v1/ground/my")
    List<GroundJoined> getMyGrounds(Authentication authentication) {
        return groundService.getMyGrounds(authUserManager.getSessionId(authentication));
    }

    // 그라운드 삭제(프로필 페이지, 어드민 페이지, 그라운드 상세 페이지)
    @DeleteMapping("/api/v1/ground/{groundId}")
    void deleteGround(@PathVariable long groundId, Authentication authentication) {
        groundService.deleteGround(authUserManager.getMe(authentication), groundId);
    }

    // 그라운드 업데이트(그라운드 업데이트 페이지?)
    @PatchMapping("/api/v1/ground/{groundId}")
    void updateGround(@PathVariable long groundId,
                     @RequestBody GroundUpdateDto groundUpdateDto) {
        groundService.updateGround(groundId, groundUpdateDto);
    }
}

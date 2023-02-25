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

    @PostMapping("/api/v1/ground")
    void createGround(@RequestBody GroundCreateDto groundCreateDto, Authentication authentication) {
        groundCreateDto.setCreateUserId(authUserManager.getSessionId(authentication));
        groundService.createGround(groundCreateDto);
    }


    @GetMapping("/api/v1/ground")
    List<GroundJoined> getGroundList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                     @RequestParam(required = false, defaultValue = "") String filter,
                                     @RequestParam(required = false, defaultValue = "asc") String sortBy,
                                     @RequestParam(required = false, defaultValue = "created_at") String orderBy,
                                     @RequestParam(required = false) String keyword) {
        return groundService.getGroundList(page, filter, sortBy, orderBy, keyword);
    }

    @GetMapping("/api/v1/ground/byme")
    List<GroundJoined> getGroundsByMe(Authentication authentication) {
        long userId = authUserManager.getSessionId(authentication);
        return groundService.getGroundsByMe(userId);
    }


    @GetMapping("/api/v1/ground/{groundId}")
    GroundJoined getGround(@PathVariable long groundId) {
        return groundService.getGroundJoinedByGroundId(groundId);
    }

    @GetMapping("/api/v1/ground/my")
    List<GroundJoined> getMyGrounds(Authentication authentication) {
        return groundService.getMyGrounds(authUserManager.getSessionId(authentication));
    }

    @DeleteMapping("/api/v1/ground/{groundId}")
    void deleteGround(@PathVariable Long groundId) {
        groundService.deleteGround(groundId);
    }

    @PatchMapping("/api/v1/ground/{groundId}")
    void updateGround(@PathVariable long groundId,
                     @RequestBody GroundUpdateDto groundUpdateDto) {
        groundService.updateGround(groundId, groundUpdateDto);
    }
}

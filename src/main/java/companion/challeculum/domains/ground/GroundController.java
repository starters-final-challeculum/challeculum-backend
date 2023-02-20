package companion.challeculum.domains.ground;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GroundController {

    private final GroundService groundService;

    private final AuthUserManager authUserManager;

    @PostMapping("/api/v1/ground")
    void createGround(@RequestBody GroundCreateDto groundCreateDTO, Authentication authentication) {
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }
        long userId = authUserManager.getSessionId(authentication);
        groundCreateDTO.setUserId(userId);
        groundService.createGround(groundCreateDTO);
    }


    @GetMapping("/api/v1/ground")
    List<GroundJoined> getGrounds(@RequestParam(required = false, defaultValue = "1") Integer page,
                                  @RequestParam(required = false, defaultValue = "") String filter,
                                  @RequestParam(required = false, defaultValue = "asc") String sortBy,
                                  @RequestParam(required = false, defaultValue = "created_at") String orderBy,
                                  @RequestParam(required = false) String keyword) {
        return groundService.getGroundList(page, filter, sortBy, orderBy, keyword);
    }

    @GetMapping("/api/v1/ground/byme")
    List<Ground> getGroundsByMe(Authentication authentication){
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }
        long userId = authUserManager.getSessionId(authentication);
        return groundService.getGroundsByMe(userId);
    }


    @GetMapping("/api/v1/ground/{groundId}")
    Ground getGround(@PathVariable long groundId) {
        return groundService.getGround(groundId);
    }

    @GetMapping("/api/v1/my/ground/{userId}")
    List<Map<String, Object>> getMyGrounds(Authentication authentication,
                                          @PathVariable long userId){
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }

        long sessUserId = authUserManager.getSessionId(authentication);
        if(sessUserId != userId){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "본인의 그라운드 목록만 조회 가능합니다.");
        }

        return groundService.getMyGrounds(userId);


    }

    @DeleteMapping("/api/v1/ground/{groundId}")
    void deleteGround(@PathVariable Long groundId) {
        groundService.deleteGround(groundId);
    }

    @PatchMapping("/api/v1/ground/{groundId}")
    int updateGround(Authentication authentication,
                     @PathVariable long groundId,
                     @RequestBody GroundUpdateDto groundUpdateDto){
        if (authentication == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }

        String role = authUserManager.getMe(authentication).getRole();

        if(!role.equalsIgnoreCase("admin")){
            Long userId = authUserManager.getSessionId(authentication);
            Long creatorId = groundService.getGroundCreator(groundId);
            if(!userId.equals(creatorId)){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "관리자나 그라운드 생성자만 업데이트 가능합니다.");
            }
        }

        if(groundUpdateDto.getIsValidated() != null || groundUpdateDto.getValidatedAt() != null){
            if(!role.equalsIgnoreCase("admin")){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "관리자만 그라운드 승인이 가능합니다.");
            }
        }

        return groundService.updateGround(groundId, groundUpdateDto);
    }
}

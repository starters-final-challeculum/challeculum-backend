package companion.challeculum.domains.ground;

import companion.challeculum.security.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
public class GroundController {
    @Autowired
    @Qualifier("groundservice")
    GroundService service;

    @PostMapping("/api/v1/ground")
    void createGround(@RequestBody CreateGroundDTO createGroundDTO) {
        service.createGround(createGroundDTO);
    }


    @GetMapping("/api/v1/ground")
    List<ListGroundDTO> getGrounds(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Integer categoryId,
                               @RequestParam(required = false) Integer level) {
        return service.getGrounds(page, categoryId, level);
    }

    @GetMapping("/api/v1/userground/{userId}")
    List<Map<String, Object>> getMyGrounds(@PathVariable long userId,
                                           @RequestParam int page,
                                           @RequestParam(required = false) String status,
                                           Authentication authentication) {
        if(authentication == null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "로그인하지 않았습니다.");
        }
        long sessUserId = ((PrincipalDetails) authentication.getPrincipal()).getUser().getId();
        boolean hasAdminRole = authentication.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
        if(sessUserId != userId && !hasAdminRole){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "본인이나 관리자만 확인 가능합니다.");
        }
        return service.getMyGrounds(userId, page, status);
    }

    @GetMapping("/api/v1/ground/{groundId}")
    GroundDTO showGroundDetail(@PathVariable long groundId) {
        return service.showGroundDetail(groundId);
    }

    @DeleteMapping("/api/v1/ground/{groundId}")
    void deleteGround(@PathVariable Long groundId) {
        service.deleteGround(groundId);
    }
}

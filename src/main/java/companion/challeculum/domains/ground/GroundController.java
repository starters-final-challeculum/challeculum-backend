package companion.challeculum.domains.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GroundController {
    @Autowired
    @Qualifier("groundservice")
    GroundService service;

    @PostMapping("/api/v1/ground")
    void createGround(@ModelAttribute GroundDTO groundDTO) {
        service.createGround(groundDTO);
    }


    @GetMapping("/api/v1/ground")
    List<GroundDTO> getGrounds(@RequestParam int page,
                               @RequestParam(required = false) Integer categoryId,
                               @RequestParam(required = false) Integer level) {
        return service.getGrounds(page, categoryId, level);
    }

    @GetMapping("/api/v1/userground/{userId}")
    List<Map<String, Object>> getMyGrounds(@PathVariable long userId,
                                           @RequestParam int page,
                                           @RequestParam(required = false) String status) {
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

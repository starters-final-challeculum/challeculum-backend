package companion.challeculum.domains.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroundController {
    @Autowired
    @Qualifier("groundservice")
    GroundService service;
    @DeleteMapping("/api/v1/ground/{groundId}")
    void deleteGround(@PathVariable Long groundId) {
        service.deleteGround(groundId);
    }
}

package companion.challeculum.domains.userground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGroundController {

    @Autowired
    @Qualifier("usergroundservice")
    UserGroundService service;

    //그라운드 참여
    @PostMapping("/api/v1/ground/{groundId}/{userId}")
    void participateGround(@PathVariable long groundId, @PathVariable long userId) {
        service.participateGround(groundId, userId);
    }

    //그라운드 참여 취소
    @PatchMapping("/api/v1/ground/{groundId}/{userId}")
    void cancelParticipateGround(@PathVariable long groundId, @PathVariable long userId) {
        service.cancelParticipateGround(groundId, userId);
    }
}

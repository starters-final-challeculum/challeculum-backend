package companion.challeculum.common;

import companion.challeculum.domains.user.dto.User;
import companion.challeculum.security.PrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by jonghyeon on 2023/02/16,
 * Package : companion.challeculum.common
 */
@Component
public class AuthUserManager {
    public Long getSessionId(Authentication authentication) {
        return ((PrincipalDetails) authentication.getPrincipal()).getUser().getUserId();
    }

    public User getMe(Authentication authentication) {
        return ((PrincipalDetails) authentication.getPrincipal()).getUser();
    }
}

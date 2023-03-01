package companion.challeculum.domains.user.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user.dtos
 */
@Builder
@Data
public final class UserRegisterDto {
    private final String oauthId;
    private final String username;
    private final String password;
    private final String nickname;
    private final String phone;

}

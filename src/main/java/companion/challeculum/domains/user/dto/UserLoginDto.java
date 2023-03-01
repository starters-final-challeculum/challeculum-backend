package companion.challeculum.domains.user.dto;

import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user.dtos
 */
@Data
public final class UserLoginDto {
    private final String username;
    private final String password;
}

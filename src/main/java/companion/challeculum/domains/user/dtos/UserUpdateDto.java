package companion.challeculum.domains.user.dtos;

import lombok.Data;

import java.util.Objects;
@Data
public final class UserUpdateDto {
    private final Long userId;
    private final String password;
    private final String nickname;
    private final String phone;
}
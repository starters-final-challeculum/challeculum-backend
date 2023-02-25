package companion.challeculum.domains.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public final class UserUpdateDto {
    private Long userId;
    private String password;
    private String nickname;
    private String phone;
    private int point;
}
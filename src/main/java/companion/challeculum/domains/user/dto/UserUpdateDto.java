package companion.challeculum.domains.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class UserUpdateDto {
    private Long userId;
    private String password;
    private String nickname;
    private String phone;
    private int point;
}
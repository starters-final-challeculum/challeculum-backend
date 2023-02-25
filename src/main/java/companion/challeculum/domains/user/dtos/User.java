package companion.challeculum.domains.user.dtos;

import lombok.Builder;
import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Data
@Builder
public final class User {
    private final long userId;
    private String oauthId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int point;
    private int missionScore;
    private String role;

    public UserInfoDto toInfoDto() {
        return new UserInfoDto(userId, username, nickname, phone, point, missionScore);
    }

    public UserUpdateDto toUpdateDto() {
        return new UserUpdateDto(userId, password, nickname, phone);
    }
}

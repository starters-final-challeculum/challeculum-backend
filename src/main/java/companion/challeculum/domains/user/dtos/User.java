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
    private final long id;
    private String oauthId;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int point;
    private int missionScore;
    private String role;

    public void changePoint(int point) {
        this.point += point;
    }

    public void changeMissionScore(int point) {
        this.missionScore += missionScore;
    }

    public UserInfoDto toInfoDto() {
        return new UserInfoDto(id, username, nickname, phone, point, missionScore);
    }

    public UserUpdateDto toUpdateDto() {
        return new UserUpdateDto(id, password, nickname, phone);
    }
}

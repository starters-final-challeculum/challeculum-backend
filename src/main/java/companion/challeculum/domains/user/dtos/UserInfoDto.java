package companion.challeculum.domains.user.dtos;

import lombok.Data;

import java.util.Objects;

/**
 * Created by jonghyeon on 2023/02/14,
 * Package : companion.challeculum.domains.user.dtos
 */
@Data
public final class UserInfoDto {
    private final long userId;
    private final String username;
    private final String nickname;
    private final String phone;
    private final int point;
    private final int missionScore;

}

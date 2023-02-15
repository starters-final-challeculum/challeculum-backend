package companion.challeculum.domains.user.dtos;

/**
 * Created by jonghyeon on 2023/02/14,
 * Package : companion.challeculum.domains.user.dtos
 */
public record UserInfoDto(long id, String username, String nickname, String phone, int point, int missionScore) {
}

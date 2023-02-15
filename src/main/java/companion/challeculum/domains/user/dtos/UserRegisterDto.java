package companion.challeculum.domains.user.dtos;

import lombok.Builder;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user.dtos
 */
@Builder
public record UserRegisterDto(String oauthId, String username, String password, String nickname, String phone) {
}

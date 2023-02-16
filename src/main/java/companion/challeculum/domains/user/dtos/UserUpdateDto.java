package companion.challeculum.domains.user.dtos;

import lombok.Builder;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Builder
public record UserUpdateDto(long id, String password, String nickname, String phone) {
}
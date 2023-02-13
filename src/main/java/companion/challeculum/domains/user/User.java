package companion.challeculum.domains.user;

import lombok.Builder;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Builder
public record User(long id, String oauthId, String username, String password, String name, String nickname, String phone, String email, String address, int point, int missionScore, Role role, String provider, String providerId) {
}

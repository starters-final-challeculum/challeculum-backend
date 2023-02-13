package companion.challeculum.security.jwt;

import lombok.Builder;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.security
 */
@Builder
public record JwtTokenInfo(String grantType, String accessToken, String refreshToken) {
}

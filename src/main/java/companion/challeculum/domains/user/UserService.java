package companion.challeculum.domains.user;

import companion.challeculum.domains.user.dtos.UserLoginDto;
import companion.challeculum.domains.user.dtos.UserRegisterDto;
import companion.challeculum.security.jwt.JwtTokenInfo;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.user
 */
public interface UserService {
    void registerUser(UserRegisterDto dto);

    JwtTokenInfo login(UserLoginDto dto);
}

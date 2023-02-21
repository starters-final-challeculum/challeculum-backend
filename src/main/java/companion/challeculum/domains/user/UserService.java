package companion.challeculum.domains.user;

import companion.challeculum.domains.user.dtos.UserInfoDto;
import companion.challeculum.domains.user.dtos.UserLoginDto;
import companion.challeculum.domains.user.dtos.UserRegisterDto;
import companion.challeculum.domains.user.dtos.UserUpdateDto;
import companion.challeculum.security.jwt.JwtTokenInfo;
import org.springframework.security.core.Authentication;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.user
 */
public interface UserService {
    void registerUser(UserRegisterDto dto);

    JwtTokenInfo login(UserLoginDto dto);

    JwtTokenInfo updateUser(Authentication authentication, UserUpdateDto dto);
    void deleteUser(Authentication authentication, long userId);

    UserInfoDto getMyInfo(Authentication authentication);
}

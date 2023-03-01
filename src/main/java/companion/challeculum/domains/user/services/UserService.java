package companion.challeculum.domains.user.services;

import companion.challeculum.domains.user.dto.UserInfoDto;
import companion.challeculum.domains.user.dto.UserLoginDto;
import companion.challeculum.domains.user.dto.UserRegisterDto;
import companion.challeculum.domains.user.dto.UserUpdateDto;
import companion.challeculum.security.jwt.JwtTokenInfo;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * Created by jonghyeon on 2023/02/17,
 * Package : companion.challeculum.domains.user
 */
public interface UserService {
    void registerUser(UserRegisterDto dto);

    JwtTokenInfo login(UserLoginDto dto);

    JwtTokenInfo updateUser(Authentication authentication, UserUpdateDto dto);

    void deleteUser(Authentication authentication, long userId);

    void deleteUser(Authentication authentication);

    UserInfoDto getMyInfo(Authentication authentication);

    List<User> selectAllUser();
}

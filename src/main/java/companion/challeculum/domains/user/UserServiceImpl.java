package companion.challeculum.domains.user;

import companion.challeculum.common.AuthUserManager;
import companion.challeculum.domains.user.dtos.*;
import companion.challeculum.security.jwt.JwtTokenInfo;
import companion.challeculum.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userdao;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    private final AuthUserManager authUserManager;

    public void registerUser(UserRegisterDto dto) {
        userdao.registerUser(UserRegisterDto.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .nickname(dto.nickname())
                .phone(dto.phone())
                .build());
    }

    @Transactional
    public JwtTokenInfo login(UserLoginDto dto) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public JwtTokenInfo updateUser(Authentication authentication, UserUpdateDto dto) {
        User me = authUserManager.getMe(authentication);
        if (dto.password() != null) me.setPassword(passwordEncoder.encode(dto.password()));
        if (dto.nickname() != null) me.setNickname(dto.nickname());
        if(dto.phone()!=null)me.setPhone(dto.phone());
        UserUpdateDto updated = me.toUpdateDto();
        userdao.updateUser(updated);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(me.getUsername(), dto.password());
        authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateToken(authentication);
    }

    @Override
    public void deleteUser(Authentication authentication, long userId) {

        userdao.deleteUser(userId);
    }

    public void deleteUser(Authentication authentication){
        long userId = authUserManager.getSessionId(authentication);

        userdao.deleteUser(userId);
    }

    @Override
    public UserInfoDto getMyInfo(Authentication authentication) {
        return userdao.findById(authUserManager.getSessionId(authentication)).get().toInfoDto();
    }
}

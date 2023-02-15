package companion.challeculum.domains.user;

import companion.challeculum.domains.user.dtos.UserLoginDto;
import companion.challeculum.domains.user.dtos.UserRegisterDto;
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
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(UserRegisterDto dto) {
        userRepository.registerUser(UserRegisterDto.builder()
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

}

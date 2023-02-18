package companion.challeculum.domains.user;

import companion.challeculum.domains.user.dtos.UserLoginDto;
import companion.challeculum.domains.user.dtos.UserRegisterDto;
import companion.challeculum.security.jwt.JwtTokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.domains.user
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public void registerUser(@RequestBody UserRegisterDto dto) {
        System.out.println(dto);
        userService.registerUser(dto);
    }

    @PostMapping("/login")
    public JwtTokenInfo login(@RequestBody UserLoginDto dto) {
        return userService.login(dto);
    }
}

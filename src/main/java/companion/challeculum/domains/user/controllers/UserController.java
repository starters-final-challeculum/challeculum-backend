package companion.challeculum.domains.user.controllers;

import companion.challeculum.domains.user.dto.UserInfoDto;
import companion.challeculum.domains.user.dto.UserLoginDto;
import companion.challeculum.domains.user.dto.UserRegisterDto;
import companion.challeculum.domains.user.dto.UserUpdateDto;
import companion.challeculum.domains.user.services.UserServiceImpl;
import companion.challeculum.security.jwt.JwtTokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
        userService.registerUser(dto);
    }

    @PostMapping("/login")
    public JwtTokenInfo login(@RequestBody UserLoginDto dto) {
        return userService.login(dto);
    }

    @PatchMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public JwtTokenInfo updateUser(Authentication authentication, @RequestBody UserUpdateDto dto) {
        return userService.updateUser(authentication, dto);
    }

    //어드민이 유저계정 삭제
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteUser(Authentication authentication, @PathVariable long userId) {
        userService.deleteUser(authentication, userId);
    }

    //본인이 계정 삭제
    @DeleteMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public void deleteUser(Authentication authentication) {
        userService.deleteUser(authentication);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_MEMBER')")
    public UserInfoDto getMyInfo(Authentication authentication) {
        return userService.getMyInfo(authentication);
    }

}

package companion.challeculum.security;

import companion.challeculum.domains.user.UserDAO;
import companion.challeculum.domains.user.dtos.User;
import companion.challeculum.security.oauth.provider.GoogleUserInfo;
import companion.challeculum.security.oauth.provider.NaverUserInfo;
import companion.challeculum.security.oauth.provider.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.security
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PrincipalDetailsService extends DefaultOAuth2UserService implements UserDetailsService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userDAO.findByUsername(username);
        System.out.println(byUsername);
        return new PrincipalDetails(userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저입니다.")));
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauthUser = super.loadUser(userRequest);

        OAuth2UserInfo info;
        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) {
            log.info("Google login");
            info = new GoogleUserInfo(oauthUser.getAttributes());
        } else if (userRequest.getClientRegistration().getRegistrationId().equals("naver")) {
            log.info("Naver login");
            info = new NaverUserInfo((Map) oauthUser.getAttributes().get("response"));
        } else {
            throw new OAuth2AuthenticationException("Not Supported Provider");
        }
        String oauthId = info.getProvider() + "-" + info.getProviderId();

        User user = userDAO.findByOAuthId(oauthId).orElseGet(() -> {
            User _user = User.builder()
                    .oauthId(oauthId)
                    .username(info.getEmail())
                    .nickname(info.getNickname())
                    .password(passwordEncoder.encode(info.getProviderId()))
                    .build();
            userDAO.registerSocialLoginUser(_user);
            return _user;
        });
        return new PrincipalDetails(user, oauthUser.getAttributes());
    }
}

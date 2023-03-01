package companion.challeculum.security.oauth;

import companion.challeculum.common.CookieUtil;
import companion.challeculum.security.jwt.JwtTokenInfo;
import companion.challeculum.security.jwt.JwtTokenProvider;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static companion.challeculum.security.oauth.CookieAuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

/**
 * Created by jonghyeon on 2023/02/14,
 * Package : companion.challeculum.security.oauth.provider
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JwtTokenProvider jwtTokenProvider;

//    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        Optional<String> redirectUri = CookieUtil.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);

        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());
        JwtTokenInfo token = jwtTokenProvider.generateToken(authentication);
        log.info("{}", token);
        String urlWithParam = UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("grantType", token.grantType())
                .queryParam("accessToken", token.accessToken())
                .queryParam("refreshToken", token.refreshToken())
                .build().toUriString();
        writeTokenResponse(response, token);
        getRedirectStrategy().sendRedirect(request, response, urlWithParam);

    }

    private void writeTokenResponse(HttpServletResponse response, JwtTokenInfo token)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Authorization", token.grantType() + " " + token.accessToken());
        response.addHeader("RefreshToken", token.refreshToken());
        response.setContentType("application/json;charset=UTF-8");
//        var writer = response.getWriter();
//        writer.println(objectMapper.writeValueAsString(token));
//        writer.flush();

        System.out.println(URLEncoder.encode(token.grantType() + " " + token.accessToken(), StandardCharsets.UTF_8));
        CookieUtil.addCookie(response, "Authorization", URLEncoder.encode(token.grantType() + " " + token.accessToken(), StandardCharsets.UTF_8), CookieUtil.ONE_DAY);
        CookieUtil.addCookie(response, "RefreshToken", token.refreshToken(), 7 * CookieUtil.ONE_WEEK);
    }
}

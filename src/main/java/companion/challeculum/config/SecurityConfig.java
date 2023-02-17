package companion.challeculum.config;

import companion.challeculum.common.Constants;
import companion.challeculum.security.JwtAuthenticationFilter;
import companion.challeculum.security.PrincipalDetailsService;
import companion.challeculum.security.jwt.JwtTokenProvider;
import companion.challeculum.security.oauth.CookieAuthorizationRequestRepository;
import companion.challeculum.security.oauth.OAuth2AuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 * Created by jonghyeon on 2023/02/12,
 * Package : companion.challeculum.config
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;
    private final PrincipalDetailsService principalDetailsService;
    private final CookieAuthorizationRequestRepository cookieAuthorizationRequestRepository;
    private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/user/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/greeting").hasAuthority(Constants.ROLE_MEMBER)
                .requestMatchers(HttpMethod.POST, "/oauth2/**").permitAll()
                .anyRequest().permitAll().and()

                //CSRF Configuration
                .csrf().disable()

                //Session Management
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                //Cors Configuration
                .cors().configurationSource(corsConfigurationSource()).and()

                //Custom Authentication(Jwt) Filter
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)

                //OAuth2 Login Configuration
                .formLogin().disable()
                .httpBasic().disable()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorization")
                .authorizationRequestRepository(cookieAuthorizationRequestRepository)
                .and()
                .userInfoEndpoint()
                .userService(principalDetailsService)
                .and()
                .successHandler(oAuth2AuthenticationSuccessHandler);
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(List.of("GET", "POST"));

        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
}
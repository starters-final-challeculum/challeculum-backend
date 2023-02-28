package companion.challeculum.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import companion.challeculum.common.exceptions.ErrorResponse;
import companion.challeculum.security.jwt.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Created by jonghyeon on 2023/02/13,
 * Package : companion.challeculum.security
 */
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = resolveToken((HttpServletRequest) request);
            if (token != null && jwtTokenProvider.validateToken(token)) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (AuthenticationException ex) {
            ErrorResponse errorResponse = new ErrorResponse();
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            errorResponse.setMessage("인증 오류 발생");
            errorResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
            return;
        } catch (AccessDeniedException ex) {
            ErrorResponse errorResponse = new ErrorResponse();
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            errorResponse.setMessage("권한 오류 발생");
            errorResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);

            response.getWriter().write(new ObjectMapper().writeValueAsString(errorResponse));
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String resolveToken(HttpServletRequest request) {
        try {
            String bearerToken = URLDecoder.decode(request.getHeader("Authorization"), StandardCharsets.UTF_8);
            if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
                return bearerToken.substring(7);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}
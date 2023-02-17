package companion.challeculum.domains.greeting;

import companion.challeculum.security.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequiredArgsConstructor
public class GreetingController {
    private final AuthenticationManager authenticationManager;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name, Authentication authentication) {
        System.out.println(getSessionId(authentication));
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    public Long getSessionId(Authentication authentication) {
        return ((PrincipalDetails) authentication.getPrincipal()).getUser().getId();
    }
}

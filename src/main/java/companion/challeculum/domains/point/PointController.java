package companion.challeculum.domains.point;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class PointController {
    @GetMapping("/api/v1/user/balance/success")
    String paymentSuccess(@RequestParam String paymentKey,
                          @RequestParam String orderId,
                          @RequestParam int amount) throws IOException, InterruptedException {
        String bodyStr = String.format("{\"paymentKey\":\"%s\",\"amount\":%s,\"orderId\":\"%s\"}", paymentKey, amount, orderId);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.tosspayments.com/v1/payments/confirm"))
                .header("Authorization", "Basic " + System.getenv("toss_payment_basic_token"))
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(bodyStr))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

    @GetMapping("/api/v1/user/balance/fail")
    ResponseEntity<ErrorDTO> paymentFail(ErrorDTO errorDTO) {
        return ResponseEntity.badRequest()
                .body(errorDTO);
    }

    @GetMapping("/api/v1/user/balance/test")
    String accessTest() {
        return "Hello World";
    }

}

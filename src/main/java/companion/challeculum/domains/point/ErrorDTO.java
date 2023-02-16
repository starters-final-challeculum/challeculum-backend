package companion.challeculum.domains.point;

import lombok.Data;

@Data
public class ErrorDTO {
    String code;
    String message;
    String orderId;
}

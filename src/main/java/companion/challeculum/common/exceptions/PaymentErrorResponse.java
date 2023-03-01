package companion.challeculum.common.exceptions;

import lombok.Data;

@Data
public class PaymentErrorResponse extends ErrorResponse {
    String orderId;
}

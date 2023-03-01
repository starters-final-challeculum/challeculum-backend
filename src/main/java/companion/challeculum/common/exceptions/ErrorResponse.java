package companion.challeculum.common.exceptions;

import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/28,
 * Package : companion.challeculum.common.exceptions
 */
@Data
public class ErrorResponse {
    private int status;
    private int errorCode;
    private String message;
    private String detail;
}
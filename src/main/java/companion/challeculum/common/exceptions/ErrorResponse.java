package companion.challeculum.common.exceptions;

import lombok.Data;

/**
 * Created by jonghyeon on 2023/02/28,
 * Package : companion.challeculum.common.exceptions
 */
@Data
public class ErrorResponse {
    private  String message;
    private int errorCode;
    private  int status;
}
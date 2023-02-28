package companion.challeculum.common.exceptions;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jonghyeon on 2023/02/28,
 * Package : companion.challeculum.common.exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("에러 메시지");
        errorResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }
}
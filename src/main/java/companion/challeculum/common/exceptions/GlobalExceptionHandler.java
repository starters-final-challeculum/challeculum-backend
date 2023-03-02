package companion.challeculum.common.exceptions;

import companion.challeculum.common.exceptions.intented.*;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static companion.challeculum.common.exceptions.ErrorCode.*;
import static jakarta.servlet.http.HttpServletResponse.*;

/**
 * Created by jonghyeon on 2023/02/28,
 * Package : companion.challeculum.common.exceptions
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    // 서버 내부 오류
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse handleException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_INTERNAL_SERVER_ERROR);
        e.printStackTrace();
        return generateErrorResponse(new ErrorResponse(), SC_INTERNAL_SERVER_ERROR, UNNAMED_SERVER_ERROR, "서버 내부 오류", e.getMessage());
    }

    // 권한 없는 요청에 대한 예외처리
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public ErrorResponse handleAccessDeniedException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_FORBIDDEN);
        return generateErrorResponse(new ErrorResponse(), SC_FORBIDDEN, ACCESS_DENIED_ERROR, "접근 권한 없음", e.getMessage());
    }

    //유효하지 않은 인증토큰에 대한 예외처리
    @ExceptionHandler(JwtException.class)
    @ResponseBody
    public ErrorResponse handleJwtException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_UNAUTHORIZED);
        return generateErrorResponse(new ErrorResponse(), SC_UNAUTHORIZED, INVALID_TOKEN_ERROR, "유효하지 않는 토큰", e.getMessage());
    }

    // 그라운드 생성자가 아닌 유저가 그라운드를 삭제 요청시 얘외처리
    @ExceptionHandler(CannotDeleteGroundException.class)
    @ResponseBody
    public ErrorResponse handleCannotDeleteGroundException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_BAD_REQUEST);
        return generateErrorResponse(new ErrorResponse(), SC_BAD_REQUEST, CANNOT_DELETE_GROUND_ERROR, "잘못된 요청", e.getMessage());
    }

    // 그라운드 참여자가 아닌 유저가 리뷰 Post 요청시 예외처리
    @ExceptionHandler(CannotReviewOnGroundException.class)
    @ResponseBody
    public ErrorResponse handleCannotReviewOnGroundException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_BAD_REQUEST);
        return generateErrorResponse(new ErrorResponse(), SC_BAD_REQUEST, CANNOT_REVIEW_ERROR, "잘못된 요청", e.getMessage());
    }

    // 그라운드에 참여한 유저가 모두 실패 했을 때 리워드 계산하는 요청 시 예외처리
    @ExceptionHandler(NoSuccessUserInGroundException.class)
    @ResponseBody
    public ErrorResponse handleNoSuccessUserInGroundException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_BAD_REQUEST);
        return generateErrorResponse(new ErrorResponse(), SC_BAD_REQUEST, NO_SUCCESS_USER_ON_GROUND_ERROR, "잘못된 요청", e.getMessage());
    }

    // 유저미션 업데이트 요청 시 제출된 미션이 없을 때 예외처리
    @ExceptionHandler(NoSubmittedMissionExistException.class)
    @ResponseBody
    public ErrorResponse handleNoSubmittedMissionExistException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_BAD_REQUEST);
        return generateErrorResponse(new ErrorResponse(), SC_BAD_REQUEST, NO_SUMMITED_MISSION_IN_GROUND_ERROR, "잘못된 요청", e.getMessage());
    }

    // 유저가 그라운드에 참여하거나 개설할 때 포인트가 예치금보다 작을때 예외처리
    @ExceptionHandler(CannotEnterGroundException.class)
    @ResponseBody
    public ErrorResponse handleUserPointDeficiencyException(HttpServletResponse response, Exception e) {
        response.setStatus(SC_BAD_REQUEST);
        return generateErrorResponse(new ErrorResponse(), SC_BAD_REQUEST, USER_POINT_DEFICIENCY_ERROR, "잘못된 요청", e.getMessage());
    }

    private ErrorResponse generateErrorResponse(ErrorResponse errorResponse, int httpStatusCode, int errorCode, String message, String detail) {
        errorResponse.setStatus(httpStatusCode);
        errorResponse.setErrorCode(errorCode);
        errorResponse.setMessage(message);
        errorResponse.setDetail(detail);
        return errorResponse;
    }
}
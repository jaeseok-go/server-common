package kr.js.commonutils.mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public final ResponseEntity<CommonResponse> handleCommonException(CommonException e) {
        return ResponseEntity.ok(CommonResponse.of(e));
    }
}

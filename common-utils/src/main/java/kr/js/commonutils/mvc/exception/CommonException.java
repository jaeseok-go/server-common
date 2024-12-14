package kr.js.commonutils.mvc.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommonException extends RuntimeException {

    private final String errorCode;

    private CommonException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public static CommonException of(String errorCode, String message) {
        return new CommonException(errorCode, message);
    }
}
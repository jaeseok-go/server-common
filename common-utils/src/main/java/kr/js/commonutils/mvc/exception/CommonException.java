package kr.js.commonutils.mvc.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommonException extends RuntimeException {

    private final String errorCode;

    private CommonException(String errorCode) {
        this(errorCode, "예외 메세지가 입력되지 않았습니다.");
    }

    private CommonException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommonException of(String errorCode, String message) {
        return new CommonException(errorCode, message);
    }
}
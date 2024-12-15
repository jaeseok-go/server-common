package kr.js.commonutils.mvc.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CommonResponse {
    private final Object value;
    private final boolean error;
    private final String errorCode;

    private CommonResponse(Object value, boolean error, String errorCode) {
        this.value = value;
        this.error = error;
        this.errorCode = errorCode;
    }

    public static CommonResponse of(Object value) {
        return new CommonResponse(value, false, "");
    }

    public static CommonResponse of(CommonException exception) {
        return new CommonResponse(exception.getMessage(), true, exception.getErrorCode());
    }
}
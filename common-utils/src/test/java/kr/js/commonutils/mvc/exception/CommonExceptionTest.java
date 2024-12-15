package kr.js.commonutils.mvc.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonExceptionTest {

    @DisplayName("유효한 에러코드와 메세지로 예외 생성 시 정상적인 예외 생성")
    @Test
    void ErrorCodeAndMessageIsValid_ConstructByFactoryMethod_ValidException() {
        String errorCode = "ERROR_CODE";
        String message = "MESSAGE";

        CommonException exception = CommonException.of(errorCode, message);

        assertEquals(errorCode, exception.getErrorCode());
        assertEquals(message, exception.getMessage());
    }
}
package kr.js.commonutils.mvc.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CommonResponseTest {

    @DisplayName("예외 타입이 아닌 객체가 공통 응답 생성 파라미터인 경우 에러가 아닌 응답 생성")
    @Test
    void NonExceptionObjectIsParameter_ConstructByFactoryMethod_CreateNonErrorResponse() {
        List<String> returnValue = Stream.of(1, 2, 3, 4, 5)
                .map(String::valueOf)
                .toList();

        CommonResponse response = CommonResponse.of(returnValue);

        assertFalse(response.isError());
        assertEquals(returnValue, response.getValue());
    }

    @DisplayName("공통 예외가 공통 응답 생성 파라미터인 경우 에러 응답 생성")
    @Test
    void CommonExceptionIsParameter_ConstructByFactoryMethod_CreateErrorResponse() {
        String errorCode = "ERROR_CODE";
        String errorMessage = "ERROR_MESSAGE";
        CommonException exception = CommonException.of(errorCode, errorMessage);

        CommonResponse response = CommonResponse.of(exception);

        assertTrue(response.isError());
        assertEquals(errorCode, response.getErrorCode());
        assertEquals(errorMessage, response.getValue());
    }
}
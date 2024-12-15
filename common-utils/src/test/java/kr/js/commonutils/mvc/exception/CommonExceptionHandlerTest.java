package kr.js.commonutils.mvc.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CommonExceptionHandlerTest {

    private final CommonExceptionHandler commonExceptionHandler = new CommonExceptionHandler();

    @DisplayName("공통 예외를 ExceptionHandler가 처리하여 공통 에러 응답 반환")
    @Test
    public void CommonException_HandlingByExceptionHandler_ReturnCommonResponse() {
        String errorCode = "ERROR_CODE";
        String errorMessage = "ERROR_MESSAGE";
        CommonException exception = CommonException.of(errorCode, errorMessage);

        ResponseEntity<CommonResponse> response = commonExceptionHandler.handleCommonException(exception);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().isError());
        assertEquals(errorCode, response.getBody().getErrorCode());
        assertEquals(errorMessage, response.getBody().getValue());
    }

}
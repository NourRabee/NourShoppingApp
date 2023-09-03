package ps.exalt.shopping.app.common.error.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ps.exalt.shopping.app.common.error.exception.OperationFailedException;
import ps.exalt.shopping.app.common.error.model.BaseErrorResponse;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OperationFailedException.class)
    public ResponseEntity<BaseErrorResponse> handleOperationFailedException(OperationFailedException ex) {
        BaseErrorResponse baseErrorResponse = new BaseErrorResponse();
        baseErrorResponse.setStatus(HttpStatus.BAD_REQUEST);
        baseErrorResponse.setMessage(ex.getMessage());
        baseErrorResponse.setTimestamp(LocalDateTime.now());
        baseErrorResponse.setMessageDetail(ex.getExtendedMessage());
        return new ResponseEntity<>(baseErrorResponse, HttpStatus.BAD_REQUEST);
    }
}

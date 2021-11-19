package za.ac.nwu.ImageShare.Domain.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiDatabaseException.class})
    public ResponseEntity<Object> handleApiDatabaseException(ApiDatabaseException e) {
        ApiException apiException = new ApiException("Database Exception", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler(value = {ApiUserException.class})
    public ResponseEntity<Object> handleApiUserException(ApiUserException e) {
        ApiException apiException = new ApiException("User Exception", e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}

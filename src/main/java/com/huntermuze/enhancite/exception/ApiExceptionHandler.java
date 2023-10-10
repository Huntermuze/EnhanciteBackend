package com.huntermuze.enhancite.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return handleGenericClientException(e);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException e) {
        return handleGenericClientException(e);
    }

    @ExceptionHandler(value = {InvalidDetailsException.class})
    public ResponseEntity<Object> handleInvalidDetailsException(InvalidDetailsException e) {
        return handleGenericClientException(e);
    }

    @ExceptionHandler(value = {UserDoesNotExistException.class})
    public ResponseEntity<Object> handleUserDoesNotExistException(UserDoesNotExistException e) {
        return handleGenericClientException(e);
    }

    @ExceptionHandler(value = {NoDataFoundException.class})
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException e) {
        return handleGenericClientException(e);
    }

    private ResponseEntity<Object> handleGenericClientException(Exception e) {
        ApiExceptionDTO apiExceptionDTO = new ApiExceptionDTO(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return ResponseEntity.badRequest().body(apiExceptionDTO);
    }

}

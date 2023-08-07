package com.pungu.Pungu.Store.CustomException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomResponseHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        String error_message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(error_message).success(false).status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleBadCredentialsException(BadCredentialsException exception){
        String error_message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(error_message).success(false).status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}


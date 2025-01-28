package com.excel.socket.core.exception;

import com.excel.socket.core.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Response<String>> userException(UserException exception) {
        return ResponseEntity.status(HttpStatus.OK).body(Response.<String>builder().message(exception.getMessage()).isError(true).build());
    }
}

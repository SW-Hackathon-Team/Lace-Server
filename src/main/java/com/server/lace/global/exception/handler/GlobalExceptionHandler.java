package com.server.lace.global.exception.handler;

import com.server.lace.global.exception.LaceException;
import com.server.lace.global.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LaceException.class)
    public ResponseEntity<ErrorResponse> laceException(LaceException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getErrorCode()), HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> processValidationException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder stringBuilder = new StringBuilder();

        bindingResult.getFieldErrors().forEach(it -> {
            stringBuilder.append(it.getDefaultMessage());
            stringBuilder.append(", ");
        });

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(", "));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        ErrorResponse errorResponse = new ErrorResponse(stringBuilder.toString(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
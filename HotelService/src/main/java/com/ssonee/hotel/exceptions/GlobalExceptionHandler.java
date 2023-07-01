package com.ssonee.hotel.exceptions;

import com.ssonee.hotel.json.ApiResponse;
import com.ssonee.hotel.json.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){

        String message = exception.getMessage();
       ApiResponse response =  ApiResponse.builder().errorInfo(ErrorInfo.builder().errorCd("1001").errorMsg(message).build())
                .TransactionStatus("F").status(HttpStatus.NOT_FOUND).build();

       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

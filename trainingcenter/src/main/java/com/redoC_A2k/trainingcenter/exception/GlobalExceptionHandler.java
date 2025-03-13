package com.redoC_A2k.trainingcenter.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.redoC_A2k.trainingcenter.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
            webRequest.getDescription(false),
            HttpStatus.INTERNAL_SERVER_ERROR,
            ex.getMessage(),
            LocalDateTime.now()
        );
        // System.out.println("Global exception: " + ex);
        return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

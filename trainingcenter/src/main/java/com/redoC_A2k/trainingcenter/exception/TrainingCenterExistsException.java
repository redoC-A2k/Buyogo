package com.redoC_A2k.trainingcenter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TrainingCenterExistsException extends RuntimeException{
    public TrainingCenterExistsException(String message) {
        super(message);
    }
}

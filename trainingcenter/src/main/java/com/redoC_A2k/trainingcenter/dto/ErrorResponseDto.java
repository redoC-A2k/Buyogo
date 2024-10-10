package com.redoC_A2k.trainingcenter.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(name = "ErrorResponse", description = "Schema to hold Error Response details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    @Schema(description = "API Path where the error occurred", example = "/api/create")
    private String apiPath;

    @Schema(description = "HTTP Status code representing the error occured", example = "500")
    private HttpStatus errorCode;

    @Schema(description = "Error message describing the error", example = "Internal Server Error")
    private String errorMessage;

    @Schema(description = "Time when the error occurred", example = "2021-09-01T12:00:00")
    private LocalDateTime errorTime; 
}

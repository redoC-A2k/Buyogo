package com.redoC_A2k.trainingcenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redoC_A2k.trainingcenter.dto.ErrorResponseDto;
import com.redoC_A2k.trainingcenter.dto.ResponseDto;
import com.redoC_A2k.trainingcenter.dto.TrainingCenterDto;
import com.redoC_A2k.trainingcenter.entity.Address;
import com.redoC_A2k.trainingcenter.service.iTrainingCenterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@AllArgsConstructor
public class TrainingCenterController {
    private iTrainingCenterService trainingCenterService;
    
    @Operation(
        summary = "Create training center api",
        description = "This api is used to create a new training center"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Training center created successfully"),
        @ApiResponse(responseCode = "400", description = "Training center already exists / Fields are not valid"),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> postMethodName(@Valid @RequestBody TrainingCenterDto trainingCenterDto) {
        System.out.println("Training Center: " + trainingCenterDto);
        trainingCenterService.saveTrainingCenter(trainingCenterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Training Center Created Successfully"));
    }
    
    @Operation(
        summary = "Get all training centers api",
        description = "This api is used to get all training centers"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200"),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))
    })
    @GetMapping("/get-all")
    public ResponseEntity<List<TrainingCenterDto>> getAllTrainingCenters(@RequestParam(required = false) @Pattern(regexp = "[a-zA-Z -]*", message = "state parameter must consists of alphabets or whitespace") String state, @RequestParam(required = false) @Pattern(regexp = "[a-zA-Z -]*",message = "city parameter must consists of alphabets or whitespace") String city) {
        if(state == null && city == null) {
            return ResponseEntity.status(HttpStatus.OK).body(trainingCenterService.getAllTrainingCenters());
        } else {
            // return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<>());
            return ResponseEntity.status(HttpStatus.OK).body(trainingCenterService.getAllTrainingCenters(city,state));
        }
    }

}

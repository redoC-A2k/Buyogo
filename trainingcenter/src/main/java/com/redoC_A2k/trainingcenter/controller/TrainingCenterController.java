package com.redoC_A2k.trainingcenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redoC_A2k.trainingcenter.dto.ResponseDto;
import com.redoC_A2k.trainingcenter.dto.TrainingCenterDto;
import com.redoC_A2k.trainingcenter.service.iTrainingCenterService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TrainingCenterController {
    private iTrainingCenterService trainingCenterService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> postMethodName(@RequestBody TrainingCenterDto trainingCenterDto) {
        System.out.println("Training Center: " + trainingCenterDto);
        trainingCenterService.saveTrainingCenter(trainingCenterDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.toString(), "Training Center Created Successfully"));
    }
    
    @GetMapping("/get-all")
    public ResponseEntity<List<TrainingCenterDto>> getAllTrainingCenters() {
        return ResponseEntity.status(HttpStatus.OK).body(trainingCenterService.getAllTrainingCenters());
    }
}

package com.redoC_A2k.trainingcenter.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.redoC_A2k.trainingcenter.dto.TrainingCenterDto;
import com.redoC_A2k.trainingcenter.entity.Address;
import com.redoC_A2k.trainingcenter.entity.TrainingCenter;
import com.redoC_A2k.trainingcenter.exception.TrainingCenterExistsException;
import com.redoC_A2k.trainingcenter.mapper.TraininigCenterMapper;
import com.redoC_A2k.trainingcenter.repository.TrainingCenterRepository;
import com.redoC_A2k.trainingcenter.service.iTrainingCenterService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrainingCenterServiceImpl implements iTrainingCenterService{
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public List<TrainingCenterDto> getAllTrainingCenters() {
        List<TrainingCenter> trainiangCenters = trainingCenterRepository.findAll();
        List<TrainingCenterDto> trainingCenterDtos = new ArrayList<>();
        for (TrainingCenter trainiangCenter : trainiangCenters) {
            TrainingCenterDto trainingCenterDto = new TrainingCenterDto();
            trainingCenterDto = TraininigCenterMapper.toDto(trainingCenterDto, trainiangCenter);
            trainingCenterDtos.add(trainingCenterDto);
        }
        return trainingCenterDtos;
    }

    @Override
    public List<TrainingCenterDto> getAllTrainingCenters(String city,String state) {
        List<TrainingCenter> trainiangCenters = new ArrayList<>();
        if(state != null && city != null) 
            trainiangCenters = trainingCenterRepository.findByCenterAddressCityAndCenterAddressState(city, state);
        else if(state != null)
            trainiangCenters = trainingCenterRepository.findByCenterAddressState(state);
        else if(city != null)
            trainiangCenters = trainingCenterRepository.findByCenterAddressCity(city);
        List<TrainingCenterDto> trainingCenterDtos = new ArrayList<>();
        for (TrainingCenter trainiangCenter : trainiangCenters) {
            TrainingCenterDto trainingCenterDto = new TrainingCenterDto();
            trainingCenterDto = TraininigCenterMapper.toDto(trainingCenterDto, trainiangCenter);
            trainingCenterDtos.add(trainingCenterDto);
        }
        return trainingCenterDtos;
    }

    @Override
    public TrainingCenter saveTrainingCenter(TrainingCenterDto trainingCenterDto) {
        TrainingCenter newTrainingCenter = new TrainingCenter();
        Optional<TrainingCenter> trainingCenter = trainingCenterRepository.findById(trainingCenterDto.getCenterCode());
        if(trainingCenter.isPresent()) {
            throw new TrainingCenterExistsException("Training center already exists with code: " + trainingCenterDto.getCenterCode());
        }
        newTrainingCenter = TraininigCenterMapper.toEntity(newTrainingCenter, trainingCenterDto);
        trainingCenterRepository.save(newTrainingCenter);
        return newTrainingCenter;
    }
}

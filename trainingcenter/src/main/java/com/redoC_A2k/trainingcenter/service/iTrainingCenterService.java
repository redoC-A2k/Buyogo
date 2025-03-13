package com.redoC_A2k.trainingcenter.service;

import java.util.List;

import com.redoC_A2k.trainingcenter.dto.TrainingCenterDto;
import com.redoC_A2k.trainingcenter.entity.TrainingCenter;


public interface iTrainingCenterService {
    public List<TrainingCenterDto> getAllTrainingCenters();
    public TrainingCenter saveTrainingCenter(TrainingCenterDto trainingCenterDto);
}

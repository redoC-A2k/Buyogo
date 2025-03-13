package com.redoC_A2k.trainingcenter.mapper;

import java.time.ZoneOffset;
import java.util.UUID;

import com.redoC_A2k.trainingcenter.dto.TrainingCenterDto;
import com.redoC_A2k.trainingcenter.entity.TrainingCenter;

public class TraininigCenterMapper {

    public static TrainingCenterDto toDto(TrainingCenterDto trainingCenterDto,TrainingCenter trainingCenter) {
        trainingCenterDto.setCenterName(trainingCenter.getCenterName());
        trainingCenterDto.setCenterCode(trainingCenter.getCenterCode());
        trainingCenterDto.setCenterAddress(trainingCenter.getCenterAddress());
        trainingCenterDto.setStudentCapacity(trainingCenter.getStudentCapacity());
        trainingCenterDto.setCoursesOffered(trainingCenter.getCoursesOffered());
        trainingCenterDto.setContactEmail(trainingCenter.getContactEmail());
        trainingCenterDto.setContactPhone(trainingCenter.getContactPhone());
        trainingCenterDto.setCreatedOn(trainingCenter.getCreatedOn().toEpochSecond(ZoneOffset.UTC));
        return trainingCenterDto;
    }

    public static TrainingCenter toEntity(TrainingCenter trainingCenter,TrainingCenterDto trainingCenterDto) {
        trainingCenter.setCenterName(trainingCenterDto.getCenterName());
        trainingCenter.setCenterCode(trainingCenterDto.getCenterCode());
        trainingCenter.setCenterAddress(trainingCenterDto.getCenterAddress());
        trainingCenter.setStudentCapacity(trainingCenterDto.getStudentCapacity());
        trainingCenter.setCoursesOffered(trainingCenterDto.getCoursesOffered());
        trainingCenter.setContactEmail(trainingCenterDto.getContactEmail());
        trainingCenter.setContactPhone(trainingCenterDto.getContactPhone());
        trainingCenter.setCenterId(UUID.randomUUID().toString());
        return trainingCenter;
    }
    
}
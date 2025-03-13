package com.redoC_A2k.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redoC_A2k.trainingcenter.entity.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,String> {
    
}
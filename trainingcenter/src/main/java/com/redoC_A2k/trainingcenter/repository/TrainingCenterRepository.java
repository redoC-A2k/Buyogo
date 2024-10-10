package com.redoC_A2k.trainingcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redoC_A2k.trainingcenter.entity.Address;
import com.redoC_A2k.trainingcenter.entity.TrainingCenter;
import java.util.List;


@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,String> {
    // List<TrainingCenter> findByCenterAddress();
    // List<TrainingCenter> findByCity(String city);
    // List<TrainingCenter> findByState(String state);
    List<TrainingCenter> findByCenterAddressCity(String city);
    List<TrainingCenter> findByCenterAddressState(String state);
    List<TrainingCenter> findByCenterAddressCityAndCenterAddressState(String city, String state);
    // List<TrainingCenter> findByCenterAddressCityAndState(String state);
    // List<TrainingCenter> findByCityAndStaxte(String city, String state);
}
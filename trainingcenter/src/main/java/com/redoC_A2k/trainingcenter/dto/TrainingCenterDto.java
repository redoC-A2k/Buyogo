package com.redoC_A2k.trainingcenter.dto;

import java.util.List;

import com.redoC_A2k.trainingcenter.entity.Address;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrainingCenterDto {
    private String centerName;
    private String centerCode;
    private Address centerAddress;
    private int studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;
    private Long createdOn;
}

package com.redoC_A2k.trainingcenter.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingCenter extends BaseEntity{
    
    @Id
    private String centerId;

    @Column(nullable = false,length = 40)
    private String centerName;

    @Column(nullable = false,length = 12)
    private String centerCode;

    @Embedded // I could have used one to many mapping here as a training center can have multiple addresses , but since in assignment it was mentioned just Object not List<Object> so I used embedded
    private Address centerAddress;

    private int studentCapacity;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "courses_offered",joinColumns = @JoinColumn(name = "center_id"))
    private List<String> coursesOffered = new ArrayList<>();

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;
}
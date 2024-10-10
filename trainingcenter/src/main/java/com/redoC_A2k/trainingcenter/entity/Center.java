package com.redoC_A2k.trainingcenter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@MappedSuperclass
@Entity
public class Center extends BaseEntity{
    
    @Id
    private Long centerId;

    @Column(nullable = false,length = 40)
    private String centerName;

    @Column(nullable = false,length = 12)
    private String centerCode;

    @Embedded
    private Address centerAddress;

    private int studentCapacity;

    @ManyToOne
    private String coursesOffered;

    @Column(nullable = false)
    private String contactEmail;

    @Column(nullable = false)
    private String contactPhone;
}
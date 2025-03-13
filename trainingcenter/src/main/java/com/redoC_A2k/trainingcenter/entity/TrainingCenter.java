package com.redoC_A2k.trainingcenter.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "training_center", indexes = {
    @Index(name = "idx_city", columnList = "city"),
    @Index(name = "idx_state", columnList = "state")
})
public class TrainingCenter extends BaseEntity{
    
    @Column(nullable = false,length = 40)
    private String centerName;

    @Id
    @Column(nullable = false,length = 12)
    private String centerCode;

    @Embedded // I could have used one to many mapping here as a training center can have multiple addresses , but since in assignment it was mentioned just Object not List<Object> so I used embedded
    @Column(nullable = false)
        @AttributeOverrides({
        @AttributeOverride(name = "city", column = @Column(name = "city", nullable = false)),
        @AttributeOverride(name = "state", column = @Column(name = "state", nullable = false))
    })
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
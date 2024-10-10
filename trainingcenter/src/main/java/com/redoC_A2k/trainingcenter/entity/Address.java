package com.redoC_A2k.trainingcenter.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    private String address;
    private String city;
    private String state;
    private String pincode;
}

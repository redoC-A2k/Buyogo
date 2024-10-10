package com.redoC_A2k.trainingcenter.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    @NotEmpty(message = "Address field of the center cannot be empty")
    private String address;
    @NotEmpty(message = "City field cannot be empty")
    private String city;
    @NotEmpty(message = "State field cannot be empty")
    private String state;
    @NotEmpty(message = "Pincode field cannot be empty")
    @Pattern(regexp = "[0-9]{6}", message = "Pincode should be a 6 digit number")
    private String pincode;
}

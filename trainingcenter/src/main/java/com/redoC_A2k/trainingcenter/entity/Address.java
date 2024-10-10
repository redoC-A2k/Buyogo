package com.redoC_A2k.trainingcenter.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(name = "Address", description = "Address of the training center")
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    @Schema(example = "123 Main Street, Near Park")
    @NotEmpty(message = "Address field of the center cannot be empty")
    private String address;

    @Schema(example = "Mumbai")
    @NotEmpty(message = "City field cannot be empty")
    private String city;

    @Schema(example = "Maharashtra")
    @NotEmpty(message = "State field cannot be empty")
    private String state;

    @Schema(example = "400001")
    @NotEmpty(message = "Pincode field cannot be empty")
    @Pattern(regexp = "[0-9]{6}", message = "Pincode should be a 6 digit number")
    private String pincode;
}

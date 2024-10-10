package com.redoC_A2k.trainingcenter.dto;

import java.util.List;

import com.redoC_A2k.trainingcenter.entity.Address;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Schema(name = "Training center details", description = "Details of the training center")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrainingCenterDto {
    @Schema(description = "Name of the training center", example = "Tech Training Center")
    @NotEmpty(message =  "Center name cannot be empty")
    @Size(min = 1, max = 40, message = "Center name should not be less than 40 characters")
    private String centerName;
    
    @Schema(description = "Code of the training center", example = "ABC123XYZ789")
    @NotEmpty(message =  "Center code cannot be empty")
    @Pattern(regexp = "[a-zA-Z0-9]{12}", message = "Center code should be alphanumeric and exactly 12 characters")
    private String centerCode;
    
    @Valid
    private Address centerAddress;

    @Schema(description = "Capacity of the training center", example = "100")
    @Valid
    private int studentCapacity;

    @Schema(description = "Courses offered by the training center", example = "[\"Java\", \"Python\", \"C++\"]")
    private List<String> coursesOffered;
    
    @Schema(description = "Contact email of the training center", example = "info@techtraining.com")
    @NotEmpty(message =  "Contact email cannot be empty")
    @Email(message = "Invalid contact email")
    private String contactEmail;

    @Schema(description = "Contact phone of the training center", example = "9876543210")
    @NotEmpty(message =  "Contact phone cannot be empty")
    @Pattern(regexp = "^(0|91)?[7-9][0-9]{9}$", message = "Contact phone should be valid Indian phone number")
    private String contactPhone;

    private Long createdOn;
}

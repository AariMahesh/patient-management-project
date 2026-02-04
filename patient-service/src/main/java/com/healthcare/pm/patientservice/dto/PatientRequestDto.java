package com.healthcare.pm.patientservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.healthcare.pm.patientservice.dto.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientRequestDto {
    @NotBlank(message = "Name is required")
    @Size(max = 100,message = "Name cannot exceed 100 chars")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "email should be valid")
    private String email;
    @NotBlank(message = "address is req")
    private String address;
    @NotNull(message = "dateOfBirth is required")
    @Past(message = "dateOfBirth must be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    @NotNull(groups = CreatePatientValidationGroup.class,message = "this is req")
    private LocalDateTime registeredDate;
}

package com.healthcare.pm.patientservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDto {
    private Integer id;
    private String name;
    private String email;
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}

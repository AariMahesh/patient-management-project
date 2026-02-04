package com.healthcare.pm.patientservice.mapper;

import com.healthcare.pm.patientservice.dto.PatientDto;
import com.healthcare.pm.patientservice.dto.PatientRequestDto;
import com.healthcare.pm.patientservice.model.Patient;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatientMapper {
    private ModelMapper modelMapper;

    public PatientDto toDto(Patient patient)
    {
        //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);


        return modelMapper.map(patient, PatientDto.class);

    }
    public Patient toEntity(PatientRequestDto patientRequestDto)
    {
       // modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);


        return modelMapper.map(patientRequestDto, Patient.class);

    }



}

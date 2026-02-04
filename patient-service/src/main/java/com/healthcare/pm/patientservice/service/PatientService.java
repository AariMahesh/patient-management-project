package com.healthcare.pm.patientservice.service;

import com.healthcare.pm.patientservice.dao.PatientDao;
import com.healthcare.pm.patientservice.dto.PatientDto;
import com.healthcare.pm.patientservice.dto.PatientRequestDto;
import com.healthcare.pm.patientservice.exception.PatientNotFoundException;
import com.healthcare.pm.patientservice.mapper.PatientMapper;
import com.healthcare.pm.patientservice.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {
    private PatientDao patientDao;
    private PatientMapper patientMapper;


    public List<PatientDto> getAll()
    {
        List<Patient> listOfPatients = patientDao.getAll();
        return listOfPatients.stream().map(patientMapper::toDto).toList();
    }

    public PatientDto createPatient(PatientRequestDto patientRequestDto)
    {
        Patient newPatient = patientMapper.toEntity(patientRequestDto);
        Patient savedPatient = patientDao.createPatient(newPatient);
        return patientMapper.toDto(savedPatient);

    }
    public PatientDto updatePatient(Integer id,PatientRequestDto patientRequestDto)
    {
        Patient patient = patientDao.findPatientById(id).orElseThrow(() -> new PatientNotFoundException("patient not found with id " + id));


        Patient updatePatient = patientDao.updatePatient(patient,patientRequestDto,id);
        return patientMapper.toDto(updatePatient);
    }
    public void deletePatient(Integer id)
    {
        Patient patient = patientDao.findPatientById(id).orElseThrow(() -> new PatientNotFoundException("patient not found with id " + id));
        patientDao.deletePatient(patient.getId());

    }


}

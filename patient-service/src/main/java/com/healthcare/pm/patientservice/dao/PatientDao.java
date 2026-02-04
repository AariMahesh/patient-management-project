package com.healthcare.pm.patientservice.dao;

import com.healthcare.pm.patientservice.dto.PatientDto;
import com.healthcare.pm.patientservice.dto.PatientRequestDto;
import com.healthcare.pm.patientservice.exception.EmailAlreadyExists;
import com.healthcare.pm.patientservice.exception.PatientNotFoundException;
import com.healthcare.pm.patientservice.model.Patient;
import com.healthcare.pm.patientservice.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientDao {
    private PatientRepository patientRepository;

    public List<Patient> getAll()
    {
        return patientRepository.findAll();

    }

    public Patient createPatient(Patient patient) {
        if(patientRepository.existsByEmail(patient.getEmail()))
        {
            throw new EmailAlreadyExists("A Patient with this email already exists "+patient.getEmail());
        }
        return patientRepository.save(patient);

    }
    public Optional<Patient> findPatientById(Integer id)
    {
         return patientRepository.findById(id);

    }
    public Patient updatePatient(Patient patient,PatientRequestDto patientRequestDto,Integer id)
    {
        if(patientRepository.existsByEmailAndIdNot(patientRequestDto.getEmail(),id))
        {
            throw new EmailAlreadyExists("A Patient with this email already exists "+patient.getEmail());
        }
        patient.setAddress(patientRequestDto.getAddress());
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setDateOfBirth(patientRequestDto.getDateOfBirth());
        return patientRepository.save(patient);
    }
    public void deletePatient(Integer id)
    {
        patientRepository.deleteById(id);

    }

}

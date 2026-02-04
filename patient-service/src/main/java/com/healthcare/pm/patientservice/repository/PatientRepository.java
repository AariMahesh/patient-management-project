package com.healthcare.pm.patientservice.repository;

import com.healthcare.pm.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer > {
     boolean existsByEmail(String email);
     boolean existsByEmailAndIdNot(String email,Integer id);
}

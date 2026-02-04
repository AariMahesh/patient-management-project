package com.healthcare.pm.patientservice.controller;

import com.healthcare.pm.patientservice.dto.PatientDto;
import com.healthcare.pm.patientservice.dto.PatientRequestDto;
import com.healthcare.pm.patientservice.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/patientService")
@AllArgsConstructor
@Tag(name ="Patient" ,description = "APIs for Patient Service")
public class PatientController {
    private PatientService patientService;

    @GetMapping("/patients")
    @Operation(summary = "Get all patients")
    public ResponseEntity<List<PatientDto>> getPatients() {
        List<PatientDto> all = patientService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @PostMapping("/create")
    @Operation(summary = "Create patient")
    public ResponseEntity<PatientDto> createPatient(@Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto) {
        PatientDto savedPatientDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(savedPatientDto);

    }
    @Operation(summary = "Update patient")
    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable(value = "id") Integer id,@Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto)
    {
        PatientDto updatedPatient = patientService.updatePatient(id, patientRequestDto);
        return ResponseEntity.ok().body(updatedPatient);

    }
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete patient")
    public ResponseEntity<Void> deletePatient(@PathVariable(value = "id") Integer id)
    {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}

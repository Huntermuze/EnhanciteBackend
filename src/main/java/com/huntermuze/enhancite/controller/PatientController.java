package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.service.ClinicianService;
import com.huntermuze.enhancite.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<Object> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{patientId}/clinician")
    public ResponseEntity<Object> getClinicianOfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(patientService.getClinicianOfPatient(patientId));
    }
}

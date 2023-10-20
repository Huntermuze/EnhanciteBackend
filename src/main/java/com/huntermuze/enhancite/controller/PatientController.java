package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping
    public ResponseEntity<Object> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{emotibitId}")
    public ResponseEntity<Object> getPatientAssociatedWithEmotibit(@PathVariable("emotibitId") String emotibitId) {
        return ResponseEntity.ok(patientService.getPatientAssociatedWithEmotibit(emotibitId));
    }

    @GetMapping("/{patientId}/clinician")
    public ResponseEntity<Object> getClinicianOfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(patientService.getClinicianOfPatient(patientId));
    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Object> removePatient(@PathVariable("patientId") long patientId) {
        patientService.removePatient(patientId);
        return ResponseEntity.ok().build();
    }
}

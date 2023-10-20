package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.service.ClinicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinician")
public class ClinicianController {
    @Autowired
    ClinicianService clinicianService;

    @GetMapping
    public ResponseEntity<Object> getAllClinicians() {
        return ResponseEntity.ok(clinicianService.getAllClinicians());
    }

    @DeleteMapping("/{clinicianId}")
    public ResponseEntity<Object> removeClinician(@PathVariable("clinicianId") long clinicianId) {
        clinicianService.removeClinician(clinicianId);
        return ResponseEntity.ok().build();
    }
}

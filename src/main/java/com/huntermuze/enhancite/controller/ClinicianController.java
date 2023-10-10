package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.service.ClinicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinician")
public class ClinicianController {
    @Autowired
    ClinicianService clinicianService;

    @GetMapping
    public ResponseEntity<Object> getAllClinicians() {
        return ResponseEntity.ok(clinicianService.getAllClinicians());
    }
}

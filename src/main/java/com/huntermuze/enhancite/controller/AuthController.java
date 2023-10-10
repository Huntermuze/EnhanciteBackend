package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.LoginAttempt;
import com.huntermuze.enhancite.dto.Patient;
import com.huntermuze.enhancite.dto.abstraction.User;
import com.huntermuze.enhancite.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping(value = "/patient", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> registerPatient(@RequestBody Patient patient) {
        authService.registerPatient(patient);
        patient.setPassword("");
        return ResponseEntity.ok(patient);
    }

    @PostMapping(value = "/clinician", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> registerClinician(@RequestBody Clinician clinician) {
        authService.registerClinician(clinician);
        clinician.setPassword("");
        return ResponseEntity.ok(clinician);
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> login(@RequestBody LoginAttempt loginAttempt) {
        User user = authService.authenticateUser(loginAttempt);
        user.setPassword("");
        if (user instanceof Clinician clinician) {
            return ResponseEntity.ok(clinician);
        }

        Patient patient = (Patient) user;
        return ResponseEntity.ok(patient);
    }
}

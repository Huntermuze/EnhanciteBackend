package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.LoginAttempt;
import com.huntermuze.enhancite.dto.Patient;
import com.huntermuze.enhancite.dto.abstraction.User;
import com.huntermuze.enhancite.exception.UserAlreadyExistsException;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void registerPatient(Patient patientToRegister) throws UserAlreadyExistsException;
    void registerClinician(Clinician clinicianToRegister) throws UserAlreadyExistsException;
    User authenticateUser(LoginAttempt loginAttempt) throws UserNotFoundException;

}

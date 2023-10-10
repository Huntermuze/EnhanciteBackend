package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.LoginAttempt;
import com.huntermuze.enhancite.dto.Patient;
import com.huntermuze.enhancite.dto.abstraction.User;
import com.huntermuze.enhancite.exception.InvalidDetailsException;
import com.huntermuze.enhancite.exception.UserAlreadyExistsException;
import com.huntermuze.enhancite.exception.UserDoesNotExistException;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import com.huntermuze.enhancite.repository.ClinicianRepository;
import com.huntermuze.enhancite.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ClinicianRepository clinicianRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerClinician(Clinician clinicianToRegister) throws UserAlreadyExistsException {
        var result = clinicianRepository.findByEmail(clinicianToRegister.getEmail());
        if (result.isPresent()) {
            throw new UserAlreadyExistsException("This clinician already exists!");
        }
        String hashedPassword = passwordEncoder.encode(clinicianToRegister.getPassword());
        clinicianToRegister.setPassword(hashedPassword);
        clinicianRepository.save(clinicianToRegister);
    }

    @Override
    public void registerPatient(Patient patientToRegister) throws UserAlreadyExistsException {
        var result = patientRepository.findByEmail(patientToRegister.getEmail());
        if (result.isPresent()) {
            throw new UserAlreadyExistsException("This patient already exists!");
        }

        var clinicianResult = clinicianRepository.findById(patientToRegister.getClinicianId());
        if (clinicianResult.isEmpty()) {
            throw new UserDoesNotExistException("This clinician (with id=" +
                    patientToRegister.getClinicianId() + ") does not exist!");
        }
        String hashedPassword = passwordEncoder.encode(patientToRegister.getPassword());
        patientToRegister.setPassword(hashedPassword);
        patientRepository.save(patientToRegister);
    }

    @Override
    public User authenticateUser(LoginAttempt loginAttempt) throws UserNotFoundException{
        var patientResult = patientRepository.findByEmail(loginAttempt.getEmail());
        var clinicianResult = clinicianRepository.findByEmail(loginAttempt.getEmail());
        if (patientResult.isEmpty() && clinicianResult.isEmpty()) {
            throw new UserNotFoundException("This user does not exist!");
        }

        User user = patientResult.isPresent() ? patientResult.get() : clinicianResult.get();
        if (!passwordEncoder.matches(loginAttempt.getPasswordProvided(), user.getPassword())) {
            throw new InvalidDetailsException("The password provided is incorrect!");
        }

        return user;
    }

}

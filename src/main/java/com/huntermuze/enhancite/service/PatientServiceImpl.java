package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.Patient;
import com.huntermuze.enhancite.dto.container.Patients;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import com.huntermuze.enhancite.repository.ClinicianRepository;
import com.huntermuze.enhancite.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ClinicianRepository clinicianRepository;

    @Override
    public Patients getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<Patient> patientsWithoutPasswords = patients.stream()
                .peek(patient -> patient.setPassword(""))
                .collect(Collectors.toList());

        return new Patients(patientsWithoutPasswords);
    }

    @Override
    public Clinician getClinicianOfPatient(long patientId) throws UserNotFoundException {
        var patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        // We can assume the clinician always exists because of the way the database is set up.
        Clinician clinician = clinicianRepository.findById(patient.get().getClinicianId()).get();
        clinician.setPassword("");
        return clinician;
    }

}

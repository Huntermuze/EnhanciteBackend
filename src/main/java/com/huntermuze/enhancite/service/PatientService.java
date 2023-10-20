package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.Patient;
import com.huntermuze.enhancite.dto.container.Patients;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {
    Patients getAllPatients();
    Clinician getClinicianOfPatient(long patientId) throws UserNotFoundException;
    Patient getPatientAssociatedWithEmotibit(String emotibitId) throws UserNotFoundException;
    void removePatient(long patientId) throws UserNotFoundException;
}

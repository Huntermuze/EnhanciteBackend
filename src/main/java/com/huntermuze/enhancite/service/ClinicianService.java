package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.container.Clinicians;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface ClinicianService {
    Clinicians getAllClinicians();
    void removeClinician(long clinicianId) throws UserNotFoundException;
}

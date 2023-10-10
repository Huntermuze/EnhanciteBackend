package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.container.Clinicians;
import org.springframework.stereotype.Service;

@Service
public interface ClinicianService {
    Clinicians getAllClinicians();
}

package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.container.Clinicians;
import com.huntermuze.enhancite.repository.ClinicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicianServiceImpl implements ClinicianService {
    @Autowired
    ClinicianRepository clinicianRepository;

    @Override
    public Clinicians getAllClinicians() {
        List<Clinician> clinicians = clinicianRepository.findAll();
        List<Clinician> clinicianListWithoutPasswords = clinicians.stream()
                .peek(clinician -> clinician.setPassword(""))
                .collect(Collectors.toList());

        return new Clinicians(clinicianListWithoutPasswords);
    }

}

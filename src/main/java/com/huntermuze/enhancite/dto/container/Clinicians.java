package com.huntermuze.enhancite.dto.container;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.repository.ClinicianRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Clinicians {
    private List<Clinician> clinicians;

    public Clinicians(List<Clinician> clinicians) {
        this.clinicians = clinicians;
    }

    public List<Clinician> getClinicians() {
        if (clinicians == null) {
            clinicians = new ArrayList<>();
        }

        return Collections.unmodifiableList(clinicians);
    }
}

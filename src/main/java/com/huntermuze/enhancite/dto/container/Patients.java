package com.huntermuze.enhancite.dto.container;

import com.huntermuze.enhancite.dto.Patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patients {
    private List<Patient> Patients;

    public Patients(List<Patient> Patients) {
        this.Patients = Patients;
    }

    public List<Patient> getPatients() {
        if (Patients == null) {
            Patients = new ArrayList<>();
        }

        return Collections.unmodifiableList(Patients);
    }
}

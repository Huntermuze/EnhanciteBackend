package com.huntermuze.enhancite.dto;

import com.huntermuze.enhancite.dto.abstraction.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Clinician")
@Table(name = "Clinician")
public class Clinician extends User {
    @Column(name = "ClinicName", nullable = false)
    private String clinicName;

    public Clinician(String firstName, String lastName, String email, String password, String clinicName) {
        super(firstName, lastName, email, password);
        this.clinicName = clinicName;
    }

    public Clinician() {
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }
}

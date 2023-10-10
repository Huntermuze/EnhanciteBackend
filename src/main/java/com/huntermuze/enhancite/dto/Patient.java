package com.huntermuze.enhancite.dto;

import com.huntermuze.enhancite.dto.abstraction.User;

import javax.persistence.*;

@Entity(name = "Patient")
@Table(name = "Patient")
public class Patient extends User {
    @Column(name = "EmotibitID", nullable = false, unique = true)
    private String emotibitId;

    @Column(name = "ClinicianID", nullable = false)
    private long clinicianId;

    public Patient(String firstName, String lastName, String email, String password, String emotibitId, long clinicianId) {
        super(firstName, lastName, email, password);
        this.emotibitId = emotibitId;
        this.clinicianId = clinicianId;
    }

    public Patient() {
    }

    public String getEmotibitId() {
        return emotibitId;
    }

    public long getClinicianId() {
        return clinicianId;
    }

    public void setEmotibitId(String emotibitId) {
        this.emotibitId = emotibitId;
    }

    public void setClinicianId(long clinicianId) {
        this.clinicianId = clinicianId;
    }
}

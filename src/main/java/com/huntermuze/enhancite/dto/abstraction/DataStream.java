package com.huntermuze.enhancite.dto.abstraction;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class DataStream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private long id;

    @Column(name = "PatientID", nullable = false)
    private long patientId;

    // Format: YYYY-MM-DD HH:MM:SS (i.e., 2023-10-09 13:24:36) - TIMESTAMP FORMAT.
    @Column(name = "DateTimeRecorded", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeRecorded;

    public DataStream(long id, long patientId, Date dateTimeRecorded) {
        this.id = id;
        this.patientId = patientId;
        this.dateTimeRecorded = dateTimeRecorded;
    }

    public DataStream() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public void setDateTimeRecorded(Date dateTimeRecorded) {
        this.dateTimeRecorded = dateTimeRecorded;
    }

    public long getId() {
        return id;
    }

    public long getPatientId() {
        return patientId;
    }

    public Date getDateTimeRecorded() {
        return dateTimeRecorded;
    }
}

package com.huntermuze.enhancite.dto;

import com.huntermuze.enhancite.dto.abstraction.DataStream;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "HeartRate")
@Table(name = "HeartRate")
public class HeartRate extends DataStream {
    @Column(name = "Value", nullable = false)
    private float value;

    public HeartRate(long id, long patientId, Date dateTimeRecorded, float value) {
        super(id, patientId, dateTimeRecorded);
        this.value = value;
    }

    public HeartRate(float value) {
        this.value = value;
    }

    public HeartRate() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

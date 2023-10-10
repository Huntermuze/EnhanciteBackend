package com.huntermuze.enhancite.dto;

import com.huntermuze.enhancite.dto.abstraction.DataStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "Temperature")
@Table(name = "Temperature")
public class Temperature extends DataStream {
    @Column(name = "Value", nullable = false)
    private float value;

    public Temperature(long id, long patientId, Date dateTimeRecorded, float value) {
        super(id, patientId, dateTimeRecorded);
        this.value = value;
    }

    public Temperature(float value) {
        this.value = value;
    }

    public Temperature() {
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}

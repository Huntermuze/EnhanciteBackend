package com.huntermuze.enhancite.dto.container;

import com.huntermuze.enhancite.dto.Clinician;
import com.huntermuze.enhancite.dto.HeartRate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeartRates {
    private List<HeartRate> heartRates;

    public HeartRates(List<HeartRate> heartRates) {
        this.heartRates = heartRates;
    }

    public List<HeartRate> getHeartRates() {
        if (heartRates == null) {
            heartRates = new ArrayList<>();
        }

        return Collections.unmodifiableList(heartRates);
    }
}

package com.huntermuze.enhancite.dto.container;

import com.huntermuze.enhancite.dto.HeartRateVariability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeartRateVariabilities {
    private List<HeartRateVariability> heartRateVariabilities;

    public HeartRateVariabilities(List<HeartRateVariability> heartRateVariabilities) {
        this.heartRateVariabilities = heartRateVariabilities;
    }

    public List<HeartRateVariability> getHeartRateVariabilities() {
        if (heartRateVariabilities == null) {
            heartRateVariabilities = new ArrayList<>();
        }

        return Collections.unmodifiableList(heartRateVariabilities);
    }
}

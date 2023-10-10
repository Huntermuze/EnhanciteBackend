package com.huntermuze.enhancite.dto.container;

import com.huntermuze.enhancite.dto.Temperature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Temperatures {
    private List<Temperature> temperatures;

    public Temperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public List<Temperature> getTemperatures() {
        if (temperatures == null) {
            temperatures = new ArrayList<>();
        }

        return Collections.unmodifiableList(temperatures);
    }
}

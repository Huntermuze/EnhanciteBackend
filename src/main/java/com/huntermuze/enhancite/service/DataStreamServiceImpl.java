package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.HeartRate;
import com.huntermuze.enhancite.dto.HeartRateVariability;
import com.huntermuze.enhancite.dto.Temperature;
import com.huntermuze.enhancite.dto.container.HeartRateVariabilities;
import com.huntermuze.enhancite.dto.container.HeartRates;
import com.huntermuze.enhancite.dto.container.Temperatures;
import com.huntermuze.enhancite.exception.NoDataFoundException;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import com.huntermuze.enhancite.repository.HeartRateRepository;
import com.huntermuze.enhancite.repository.HeartRateVariabilityRepository;
import com.huntermuze.enhancite.repository.PatientRepository;
import com.huntermuze.enhancite.repository.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataStreamServiceImpl implements DataStreamService {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    HeartRateRepository heartRateRepository;
    @Autowired
    TemperatureRepository temperatureRepository;
    @Autowired
    HeartRateVariabilityRepository heartRateVariabilityRepository;

    @Override
    public HeartRate getLatestHROfPatient(long patientId) throws UserNotFoundException, NoDataFoundException {
        var patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        var heartRate = heartRateRepository.findLatestHeartRateOfPatient(patientId);
        if (heartRate.isEmpty()) {
            throw new NoDataFoundException("No heart rate data has been uploaded for patient with id " + patientId + "!");
        }

        return heartRate.get();
    }

    @Override
    public HeartRates getAllHRHistoryOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException {
        var patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        List<HeartRate> heartRates = heartRateRepository.findAllHeartRateHistoryOfPatient(patientId);
        if (heartRates.isEmpty()) {
            throw new NoDataFoundException("No heart rate data has been uploaded for patient with id " + patientId + "!");
        }

        return new HeartRates(heartRates);
    }

    @Override
    public Temperature getLatestT1OfPatient(long patientId) throws UserNotFoundException, NoDataFoundException {
        var patient = temperatureRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        var temperature = temperatureRepository.findLatestTemperatureOfPatient(patientId);
        if (temperature.isEmpty()) {
            throw new NoDataFoundException("No temperature data has been uploaded for patient with id " + patientId + "!");
        }

        return temperature.get();
    }

    @Override
    public Temperatures getAllT1HistoryOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException {
        var patient = temperatureRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        List<Temperature> temps = temperatureRepository.findAllTemperatureHistoryOfPatient(patientId);
        if (temps.isEmpty()) {
            throw new NoDataFoundException("No temperature data has been uploaded for patient with id " + patientId + "!");
        }

        return new Temperatures(temps);
    }

    @Override
    public HeartRateVariability getLatestBIOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException {
        var patient = heartRateVariabilityRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        var bi = heartRateVariabilityRepository.findLatestHeartRateVariabilityOfPatient(patientId);
        if (bi.isEmpty()) {
            throw new NoDataFoundException("No heart rate variability data has been uploaded for patient with id " + patientId + "!");
        }

        return bi.get();
    }

    @Override
    public HeartRateVariabilities getAllBIHistoryOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException {
        var patient = heartRateVariabilityRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new UserNotFoundException("Patient with id " + patientId + " does not exist!");
        }
        List<HeartRateVariability> bis = heartRateVariabilityRepository.findAllHeartRateVariabilityHistoryOfPatient(patientId);
        if (bis.isEmpty()) {
            throw new NoDataFoundException("No heart rate variability data has been uploaded for patient with id " + patientId + "!");
        }

        return new HeartRateVariabilities(bis);
    }
}

package com.huntermuze.enhancite.service;

import com.huntermuze.enhancite.dto.HeartRate;
import com.huntermuze.enhancite.dto.HeartRateVariability;
import com.huntermuze.enhancite.dto.Temperature;
import com.huntermuze.enhancite.dto.container.HeartRateVariabilities;
import com.huntermuze.enhancite.dto.container.HeartRates;
import com.huntermuze.enhancite.dto.container.Temperatures;
import com.huntermuze.enhancite.exception.NoDataFoundException;
import com.huntermuze.enhancite.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface DataStreamService {
    HeartRate getLatestHROfPatient(long patientId) throws UserNotFoundException, NoDataFoundException;

    HeartRates getAllHRHistoryOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException;

    Temperature getLatestT1OfPatient(long patientId) throws UserNotFoundException, NoDataFoundException;

    Temperatures getAllT1HistoryOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException;

    HeartRateVariabilities getAllBIHistoryOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException;

    HeartRateVariability getLatestBIOfPatient(long patientId) throws UserNotFoundException, NoDataFoundException;
}

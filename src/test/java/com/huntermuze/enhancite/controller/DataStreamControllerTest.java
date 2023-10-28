package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.dto.HeartRate;
import com.huntermuze.enhancite.dto.HeartRateVariability;
import com.huntermuze.enhancite.dto.Temperature;
import com.huntermuze.enhancite.dto.container.HeartRateVariabilities;
import com.huntermuze.enhancite.dto.container.HeartRates;
import com.huntermuze.enhancite.dto.container.Temperatures;
import com.huntermuze.enhancite.service.DataStreamService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DataStreamControllerTest {
    @MockBean
    private DataStreamService dataStreamService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getLatestHROfPatient() throws Exception {
        // given
        long id = 9;
        long patient_id = 1;
        Date date = Date.from(Instant.parse("2021-04-20T15:00:00.000+00:00"));
        HeartRate heartRate = new HeartRate(id, patient_id, date, 68.8F);
        // Mock behaviour of dataStreamService.
        Mockito.when(dataStreamService.getLatestHROfPatient(patient_id)).thenReturn(heartRate);
        // when - call the controller method to test it.
        mockMvc.perform(MockMvcRequestBuilders.get("/datastream/hr/latest/{patientId}", patient_id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(4)))
                .andExpect(MockMvcResultMatchers.content().json("{'id': 9, 'patientId': 1, 'dateTimeRecorded': '2021-04-20T15:00:00.000+00:00', 'value': 68.8}"));
        // then - verify that the service method was called.
        Mockito.verify(dataStreamService).getLatestHROfPatient(patient_id);
    }

    @Test
    public void getAllHRHistoryOfPatient() throws Exception {
        // given
        long patient_id = 1;
        Date date = Date.from(Instant.parse("2021-04-20T15:00:00.000+00:00"));
        HeartRates heartRates = new HeartRates(new ArrayList<>(List.of(
                new HeartRate(9, patient_id, date, 68.8F),
                new HeartRate(10, patient_id, date, 69.8F),
                new HeartRate(11, patient_id, date, 70.8F),
                new HeartRate(12, patient_id, date, 79.1F)
        )));
        // Mock behaviour of dataStreamService.
        Mockito.when(dataStreamService.getAllHRHistoryOfPatient(patient_id)).thenReturn(heartRates);
        // when - call the controller method to test it.
        mockMvc.perform(MockMvcRequestBuilders.get("/datastream/hr/all/{patientId}", patient_id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.heartRates", Matchers.hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.heartRates[2].id", Matchers.is(11)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.heartRates[0].value", Matchers.is(68.8)));
        // then - verify that the service method was called.
        Mockito.verify(dataStreamService).getAllHRHistoryOfPatient(patient_id);
    }

    @Test
    public void getLatestT1OfPatient() throws Exception {
        // given
        long id = 9;
        long patient_id = 1;
        Date date = Date.from(Instant.parse("2021-04-20T15:00:00.000+00:00"));
        Temperature temperature = new Temperature(id, patient_id, date, 68.8F);
        // Mock behaviour of dataStreamService.
        Mockito.when(dataStreamService.getLatestT1OfPatient(patient_id)).thenReturn(temperature);
        // when - call the controller method to test it.
        mockMvc.perform(MockMvcRequestBuilders.get("/datastream/t1/latest/{patientId}", patient_id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(4)))
                .andExpect(MockMvcResultMatchers.content().json("{'id': 9, 'patientId': 1, 'dateTimeRecorded': '2021-04-20T15:00:00.000+00:00', 'value': 68.8}"));
        // then - verify that the service method was called.
        Mockito.verify(dataStreamService).getLatestT1OfPatient(patient_id);
    }

    @Test
    public void getAllT1HistoryOfPatient() throws Exception {
        // given
        long patient_id = 1;
        Date date = Date.from(Instant.parse("2021-04-20T15:00:00.000+00:00"));
        Temperatures temperatures = new Temperatures(new ArrayList<>(List.of(
                new Temperature(9, patient_id, date, 68.8F),
                new Temperature(10, patient_id, date, 69.8F),
                new Temperature(11, patient_id, date, 70.8F),
                new Temperature(12, patient_id, date, 79.1F)
        )));
        // Mock behaviour of dataStreamService.
        Mockito.when(dataStreamService.getAllT1HistoryOfPatient(patient_id)).thenReturn(temperatures);
        // when - call the controller method to test it.
        mockMvc.perform(MockMvcRequestBuilders.get("/datastream/t1/all/{patientId}", patient_id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures", Matchers.hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures[2].id", Matchers.is(11)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.temperatures[0].value", Matchers.is(68.8)));
        // then - verify that the service method was called.
        Mockito.verify(dataStreamService).getAllT1HistoryOfPatient(patient_id);
    }

    @Test
    public void getLatestBIOfPatient() throws Exception {
        // given
        long id = 9;
        long patient_id = 1;
        Date date = Date.from(Instant.parse("2021-04-20T15:00:00.000+00:00"));
        HeartRateVariability heartRateVariability = new HeartRateVariability(id, patient_id, date, 68.8F);
        // Mock behaviour of dataStreamService.
        Mockito.when(dataStreamService.getLatestBIOfPatient(patient_id)).thenReturn(heartRateVariability);
        // when - call the controller method to test it.
        mockMvc.perform(MockMvcRequestBuilders.get("/datastream/bi/latest/{patientId}", patient_id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(4)))
                .andExpect(MockMvcResultMatchers.content().json("{'id': 9, 'patientId': 1, 'dateTimeRecorded': '2021-04-20T15:00:00.000+00:00', 'value': 68.8}"));
        // then - verify that the service method was called.
        Mockito.verify(dataStreamService).getLatestBIOfPatient(patient_id);
    }

    @Test
    public void getAllBIHistoryOfPatient() throws Exception {
        // given
        long patient_id = 1;
        Date date = Date.from(Instant.parse("2021-04-20T15:00:00.000+00:00"));
        HeartRateVariabilities heartRateVariabilities = new HeartRateVariabilities(new ArrayList<>(List.of(
                new HeartRateVariability(9, patient_id, date, 68.8F),
                new HeartRateVariability(10, patient_id, date, 69.8F),
                new HeartRateVariability(11, patient_id, date, 70.8F),
                new HeartRateVariability(12, patient_id, date, 79.1F)
        )));
        // Mock behaviour of dataStreamService.
        Mockito.when(dataStreamService.getAllBIHistoryOfPatient(patient_id)).thenReturn(heartRateVariabilities);
        // when - call the controller method to test it.
        mockMvc.perform(MockMvcRequestBuilders.get("/datastream/bi/all/{patientId}", patient_id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.heartRateVariabilities", Matchers.hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.heartRateVariabilities[2].id", Matchers.is(11)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.heartRateVariabilities[0].value", Matchers.is(68.8)));
        // then - verify that the service method was called.
        Mockito.verify(dataStreamService).getAllBIHistoryOfPatient(patient_id);
    }
}

package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.dto.HeartRate;
import com.huntermuze.enhancite.dto.HeartRateVariability;
import com.huntermuze.enhancite.dto.Temperature;
import com.huntermuze.enhancite.service.DataStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/datastream")
public class DataStreamController {
    @Autowired
    DataStreamService dataStreamService;

    @PostMapping(path = "/hr", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addHeartRate(@RequestBody HeartRate heartRate) {
        dataStreamService.saveHeartRate(heartRate);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/t1", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addTemperature(@RequestBody Temperature temperature) {
        dataStreamService.saveTemperature(temperature);
        return ResponseEntity.ok().build();
    }


    @PostMapping(path = "/bi", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addHeartRateVariability(@RequestBody HeartRateVariability heartRateVariability) {
        dataStreamService.saveHeartRateVariability(heartRateVariability);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/hr/latest/{patientId}")
    public ResponseEntity<Object> getLatestHROfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(dataStreamService.getLatestHROfPatient(patientId));
    }

    @GetMapping("/hr/all/{patientId}")
    public ResponseEntity<Object> getAllHRHistoryOfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(dataStreamService.getAllHRHistoryOfPatient(patientId));
    }

    @GetMapping("/t1/latest/{patientId}")
    public ResponseEntity<Object> getLatestT1OfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(dataStreamService.getLatestT1OfPatient(patientId));
    }

    @GetMapping("/t1/all/{patientId}")
    public ResponseEntity<Object> getAllT1HistoryOfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(dataStreamService.getAllT1HistoryOfPatient(patientId));
    }

    @GetMapping("/bi/latest/{patientId}")
    public ResponseEntity<Object> getLatestBIOfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(dataStreamService.getLatestBIOfPatient(patientId));
    }

    @GetMapping("/bi/all/{patientId}")
    public ResponseEntity<Object> getAllBIHistoryOfPatient(@PathVariable("patientId") long patientId) {
        return ResponseEntity.ok(dataStreamService.getAllBIHistoryOfPatient(patientId));
    }
}

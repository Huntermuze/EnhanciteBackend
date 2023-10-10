package com.huntermuze.enhancite.controller;

import com.huntermuze.enhancite.service.DataStreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datastream")
public class DataStreamController {
    @Autowired
    DataStreamService dataStreamService;

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
}

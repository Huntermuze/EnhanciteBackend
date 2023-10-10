package com.huntermuze.enhancite.repository;

import com.huntermuze.enhancite.dto.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
    @Query(value = "SELECT * FROM temperature WHERE patientId = ?1", nativeQuery = true)
    Optional<Temperature> findByPatientId(long patientId);

    @Query(value = "SELECT * FROM temperature WHERE patientId = ?1 ORDER BY date_time_recorded DESC LIMIT 1", nativeQuery = true)
    Optional<Temperature> findLatestTemperatureOfPatient(long patientId);

    @Query(value = "SELECT * FROM temperature WHERE patientId = ?1", nativeQuery = true)
    List<Temperature> findAllTemperatureHistoryOfPatient(long patientId);
}

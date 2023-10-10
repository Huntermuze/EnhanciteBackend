package com.huntermuze.enhancite.repository;

import com.huntermuze.enhancite.dto.HeartRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
    @Query(value = "SELECT * FROM heart_rate WHERE patientId = ?1", nativeQuery = true)
    Optional<HeartRate> findByPatientId(long patientId);

    @Query(value = "SELECT * FROM heart_rate WHERE patientId = ?1 ORDER BY date_time_recorded DESC LIMIT 1", nativeQuery = true)
    Optional<HeartRate> findLatestHeartRateOfPatient(long patientId);

    @Query(value = "SELECT * FROM heart_rate WHERE patientId = ?1", nativeQuery = true)
    List<HeartRate> findAllHeartRateHistoryOfPatient(long patientId);

}

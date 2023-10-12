package com.huntermuze.enhancite.repository;

import com.huntermuze.enhancite.dto.HeartRateVariability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeartRateVariabilityRepository extends JpaRepository<HeartRateVariability, Long> {
    @Query(value = "SELECT * FROM heart_rate_variability WHERE patientId = ?1", nativeQuery = true)
    Optional<HeartRateVariability> findByPatientId(long patientId);

    @Query(value = "SELECT * FROM heart_rate_variability WHERE patientId = ?1 ORDER BY date_time_recorded DESC LIMIT 1", nativeQuery = true)
    Optional<HeartRateVariability> findLatestHeartRateVariabilityOfPatient(long patientId);

    @Query(value = "SELECT * FROM heart_rate_variability WHERE patientId = ?1", nativeQuery = true)
    List<HeartRateVariability> findAllHeartRateVariabilityHistoryOfPatient(long patientId);

}
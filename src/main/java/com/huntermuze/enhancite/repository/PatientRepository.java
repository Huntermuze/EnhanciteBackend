package com.huntermuze.enhancite.repository;

import com.huntermuze.enhancite.dto.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query(value = "SELECT * FROM patient WHERE email = ?1", nativeQuery = true)
    Optional<Patient> findByEmail(String email);

    @Query(value = "SELECT * FROM patient WHERE emotibitId = ?1", nativeQuery = true)
    Optional<Patient> findByEmotibitId(String emotibitId);
}

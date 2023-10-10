package com.huntermuze.enhancite.repository;

import com.huntermuze.enhancite.dto.Clinician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClinicianRepository extends JpaRepository<Clinician, Long> {
    @Query(value = "SELECT * FROM clinician WHERE email = ?1", nativeQuery = true)
    Optional<Clinician> findByEmail(String email);
}

package com.example.detistapointment.repository;

import com.example.detistapointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Find patient by ID
    Optional<Patient> findById(Long id);

    // Find all patients
    List<Patient> findAll();

    // Save or update a patient
    <S extends Patient> S save(S patient);

    // Delete a patient by ID
    void deleteById(Long id);

    @Query("SELECT p FROM Patient p JOIN FETCH p.adress")
    List<Patient> findAllPaintWithAddress();

    @Query("SELECT p FROM Patient p JOIN FETCH p.adress WHERE p.patientId = :patientId")
    Optional<Patient> findByIdWithAddress(@Param("patientId") Integer patientId);

    @Query("SELECT p FROM Patient p WHERE p.firstName LIKE %:searchString% OR p.lastName LIKE %:searchString%")
    List<Patient> searchPatients(@Param("searchString") String searchString);
}

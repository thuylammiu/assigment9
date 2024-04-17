package com.example.detistapointment.repository;

import com.example.detistapointment.model.Dentist;
import com.example.detistapointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetistRepository extends JpaRepository<Dentist, Long> {
    // Find patient by ID
    Optional<Dentist> findById(Long id);

    // Find all patients
    List<Dentist> findAll();

    // Save or update a patient
    <S extends Dentist> S save(S Dentist);

    // Delete a patient by ID
    void deleteById(Long id);
}

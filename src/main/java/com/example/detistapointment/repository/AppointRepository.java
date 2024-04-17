package com.example.detistapointment.repository;

import com.example.detistapointment.model.Appointment;
import com.example.detistapointment.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AppointRepository extends JpaRepository<Appointment, Long> {
    // Find patient by ID
    Optional<Appointment> findById(Long id);

    // Find all patients
    List<Appointment> findAll();

    // Save or update a patient
    <S extends Appointment> S save(S Appointment);

    // Delete a patient by ID
    void deleteById(Long id);
}

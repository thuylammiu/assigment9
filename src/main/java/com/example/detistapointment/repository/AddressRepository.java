package com.example.detistapointment.repository;

import com.example.detistapointment.model.Address;
import com.example.detistapointment.model.Dentist;
import com.example.detistapointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    // Find patient by ID
    Optional<Address> findById(Long id);

    // Find all patients
    List<Address> findAll();

    // Save or update a patient
    <S extends Address> S save(S Address);

    // Delete a patient by ID
    void deleteById(Long id);

    @Query("SELECT p FROM Address p JOIN FETCH p.patient")
    List<Address> findAllAddressWithPatient();
}

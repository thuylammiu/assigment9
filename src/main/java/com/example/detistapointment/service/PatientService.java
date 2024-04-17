package com.example.detistapointment.service;

import com.example.detistapointment.common.exception.NotFoundException;
import com.example.detistapointment.dto.PatientDto;
import com.example.detistapointment.model.Patient;
import com.example.detistapointment.repository.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }

    public List<PatientDto> findPatientList() {
        return patientRepository.findAll().stream().map(this::copyPatientEntityToDto).collect(Collectors.toList());
    }

    public List<PatientDto> getAllPatientsWithAddress() {
        //var result =  patientRepository.findAllPaintWithAddress();
        return patientRepository.findAllPaintWithAddress().stream().map(this::copyPatientEntityToDto).collect(Collectors.toList());
    }

    public Optional<PatientDto> getPatientByIdWithAddress(Integer patientId) {
        try {
            var result =  patientRepository.findByIdWithAddress(patientId);
            return Optional.ofNullable(result.map(this::copyPatientEntityToDto).orElse(null));
        }
        catch( Exception e ) {
            throw new NotFoundException("PaintId not found " + patientId);

        }


    }

    public List<PatientDto> searchPatients(String searchString) {

        return patientRepository.searchPatients(searchString).stream().map(this::copyPatientEntityToDto).collect(Collectors.toList());

    }

    public PatientDto createOrUpdateEmployee(PatientDto dto) {
        try {
            Patient entity = copyPatientDtoToEntity(dto);
            patientRepository.save(entity);
        } catch (DataIntegrityViolationException ex) {
            throw  ex;
        }
        return dto;
    }

    private Patient copyPatientDtoToEntity(PatientDto patientDto) {
        Patient entity = new Patient();
        BeanUtils.copyProperties(patientDto, entity);
        return entity;
    }

    private PatientDto copyPatientEntityToDto(Patient entity) {
        PatientDto dto = new PatientDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}

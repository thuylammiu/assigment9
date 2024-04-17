package com.example.detistapointment.service;

import com.example.detistapointment.model.Dentist;
import com.example.detistapointment.model.Patient;
import com.example.detistapointment.repository.DetistRepository;
import com.example.detistapointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetistService {
    @Autowired
    private DetistRepository detistRepository;

    public Dentist createDentist(Dentist dentist) {
        return detistRepository.save(dentist);
    }

    public Dentist getDentistById(Long id) {
        return detistRepository.findById(id).orElse(null);
    }

    public List<Dentist> getAllDentists() {
        return detistRepository.findAll();
    }

    public Dentist updateDentistDentist(Dentist dentist) {
        return detistRepository.save(dentist);
    }

    public void deleteDentistById(Long id) {
        detistRepository.deleteById(id);
    }
}

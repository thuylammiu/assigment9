package com.example.detistapointment.service;

import com.example.detistapointment.model.Appointment;
import com.example.detistapointment.model.Patient;
import com.example.detistapointment.repository.AppointRepository;
import com.example.detistapointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointRepository appointRepository;

    public Appointment createAppointment(Appointment app) {
        return appointRepository.save(app);
    }

    public Appointment getAppointmentById(Long id) {
        return appointRepository.findById(id).orElse(null);
    }

    public List<Appointment> getAllAppointments() {
        return appointRepository.findAll();
    }

    public Appointment updatePatient(Appointment appointment) {
        return appointRepository.save(appointment);
    }

    public void deleteappointmentById(Long id) {
        appointRepository.deleteById(id);
    }
}

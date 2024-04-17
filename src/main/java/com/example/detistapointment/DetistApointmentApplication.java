package com.example.detistapointment;

import com.example.detistapointment.model.Address;
import com.example.detistapointment.model.Appointment;
import com.example.detistapointment.model.Dentist;
import com.example.detistapointment.model.Patient;
import com.example.detistapointment.service.AddressService;
import com.example.detistapointment.service.AppointmentService;
import com.example.detistapointment.service.DetistService;
import com.example.detistapointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication

public class DetistApointmentApplication implements CommandLineRunner {
    @Autowired
    private PatientService patientService;

    @Autowired
    private DetistService dentistService;

    @Autowired
    private AppointmentService appService;

    @Autowired
    private AddressService addService;


    public static void main(String[] args)
    {
        SpringApplication.run(DetistApointmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] dentistNames = {"Tony Smith", "Helen Pearson", "Robin Plevin"};
        String[] patNos = {"P100", "P105", "P108", "P110"};
        String[] patNames = {"Gillian White", "Jill Bell", "Ian MacKay", "John Walker"};
        LocalDate[] appointmentDates = {LocalDate.of(2013, 9, 12), LocalDate.of(2013, 9, 12), LocalDate.of(2013, 9, 12),
                LocalDate.of(2013, 9, 14), LocalDate.of(2013, 9, 14), LocalDate.of(2013, 9, 15)};
        LocalTime[] appointmentTimes = {LocalTime.of(10, 0), LocalTime.of(12, 0), LocalTime.of(10, 0),
                LocalTime.of(14, 0), LocalTime.of(16, 30), LocalTime.of(18, 0)};
        String[] surgeryNos = {null, null, null, null, null, null};

        Patient patient = new Patient();
        patient.setFirstName("Gillian");
        patient.setLastName("White");

        patientService.createPatient(patient);

        Patient patient1 = new Patient();
        patient1.setFirstName("Lam");

        patient1.setLastName("Nguyen");

        Address address = new Address();
        address.setCity("FairField");
        address.setState("Iowa");
        address.setZipcode("5521");
        addService.createAddress(address);
        patient1.setAdress(address);
        patientService.createPatient(patient1);



        /*Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDentist(dentist);
        //appointment.setDateTime(appointmentDates[0]);
        appointment.setDateTime(LocalDate.of(2013, 9, 12).atStartOfDay());
        //appointment.setSurgeryNo(surgeryNos[i]);
        appService.createAppointment(appointment);

        List<Appointment> appointments = appService.getAllAppointments();
        appointments.forEach(System.out::println);*/

        var result = addService.findAllAddressWithPatient();
    }

}

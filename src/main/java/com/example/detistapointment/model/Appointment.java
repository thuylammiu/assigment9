package com.example.detistapointment.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appointment")
public class Appointment {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Dentist dentist;
    private LocalDateTime dateTime;
    @ManyToOne
    private Surgery surgery;

    private boolean cancelled;


}

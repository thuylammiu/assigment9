package com.example.detistapointment.model;
import jakarta.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Builder
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="patient")
public class Patient {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @Nonnull
    private String firstName;

    @Nonnull
    private String lastName;

    @Nonnull
    private String phoneNumber;
    private String email;
    private String mailingAddress;
    private LocalDate dateOfBirth;

    @OneToOne(fetch = FetchType.EAGER)
    private Address adress;

}

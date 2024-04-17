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

@Table(name="address")
public class Address {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String city;

    private String state;

    private String Zipcode;

    @OneToOne(fetch = FetchType.EAGER)
    private Patient patient;


}

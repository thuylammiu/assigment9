package com.example.detistapointment.dto;



import com.example.detistapointment.model.Address;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PatientDto {
    private Integer patientId;
    private String firstName;

    private String lastName;

    private String phoneNumber;
    private String email;
    private String mailingAddress;
    private LocalDate dateOfBirth;
    private Address adress;
    private String city;

    private String state;

    private String Zipcode;
}

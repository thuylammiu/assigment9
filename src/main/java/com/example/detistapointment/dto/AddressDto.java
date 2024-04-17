package com.example.detistapointment.dto;

import com.example.detistapointment.model.Patient;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class AddressDto {

    private Integer addressId;

    private String city;

    private String state;

    private String Zipcode;


    private Patient patient;
}

package com.example.detistapointment.service;

import com.example.detistapointment.dto.AddressDto;
import com.example.detistapointment.dto.PatientDto;
import com.example.detistapointment.model.Dentist;
import com.example.detistapointment.model.Patient;
import com.example.detistapointment.repository.AddressRepository;
import com.example.detistapointment.repository.DetistRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.detistapointment.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address getaddresstById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public List<Address> getAllDentists() {
        return addressRepository.findAll();
    }

    public Address updateDentistDentist(Address dentist) {
        return addressRepository.save(dentist);
    }

    public void deleteDentistById(Long id) {
        addressRepository.deleteById(id);
    }

    public List<AddressDto> findAllAddressWithPatient() {
        var result =  addressRepository.findAllAddressWithPatient();
        return addressRepository.findAllAddressWithPatient().stream().map(this::copyAddressEntityToDto).collect(Collectors.toList());
    }

    private AddressDto copyAddressEntityToDto(Address entity) {
        AddressDto dto = new AddressDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}

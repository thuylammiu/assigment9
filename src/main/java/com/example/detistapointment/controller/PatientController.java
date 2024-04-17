package com.example.detistapointment.controller;

import com.example.detistapointment.dto.AddressDto;
import com.example.detistapointment.dto.PatientDto;
import com.example.detistapointment.service.AddressService;
import com.example.detistapointment.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/adsweb/api/v1/patient/")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private AddressService addService;
    @GetMapping(value = "list")
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        List<PatientDto> list = patientService.getAllPatientsWithAddress()
                .stream()
                .sorted(Comparator.comparing(PatientDto::getLastName))
                .collect(Collectors.toList());
        return new ResponseEntity<List<PatientDto>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "get/{id}")
    public ResponseEntity<PatientDto> getPatientById( @PathVariable("id") Integer id) {
        var item = patientService.getPatientByIdWithAddress(id);
        return new ResponseEntity<PatientDto>(item.get(), HttpStatus.OK);
    }

    @PostMapping(value = { "register" })
    public ResponseEntity<PatientDto> createPatient( @RequestBody PatientDto dto) {
        var result = patientService.createOrUpdateEmployee(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = { "update/{id}" })
    public ResponseEntity<PatientDto> updatePatient( @RequestBody PatientDto dto) {
        var result = patientService.createOrUpdateEmployee(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) {
        patientService.deletePatientById(id);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
    }

    @GetMapping(value = "search/{searchString}")
    public ResponseEntity<List<PatientDto>> searchPatiens(@PathVariable("searchString") String searchString) {
        var result = patientService.searchPatients(searchString);
        return new ResponseEntity<List<PatientDto>>(result, HttpStatus.OK);
    }

    @GetMapping(value = "address/list")
    public ResponseEntity<List<AddressDto>> getAllAddress() {
        List<AddressDto> list = addService.findAllAddressWithPatient()
                .stream()
                .sorted(Comparator.comparing(AddressDto::getCity))
                .collect(Collectors.toList());
        return new ResponseEntity<List<AddressDto>>(list, HttpStatus.OK);
    }
}

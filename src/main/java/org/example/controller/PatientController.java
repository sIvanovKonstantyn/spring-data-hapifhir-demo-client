package org.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.example.controller.entities.PatientDto;
import org.example.repository.PatientRepository;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @GetMapping
    public List<PatientDto> findAll() {
        return repository.findAll()
            .stream()
            .map(p -> new PatientDto(p.getNameFirstRep().getNameAsSingleString()))
            .collect(Collectors.toList());
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) {
        return repository.save(patient);
    }
    @GetMapping("/{id}")
    public Patient findOne(@PathVariable String id) {
        return repository.findById(id).orElseThrow();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }
}


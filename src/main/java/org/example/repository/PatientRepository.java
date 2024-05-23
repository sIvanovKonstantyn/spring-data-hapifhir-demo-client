package org.example.repository;

import org.hl7.fhir.r4.model.Patient;
import org.springframework.data.repository.ListCrudRepository;

public interface PatientRepository extends ListCrudRepository<Patient, String> {

}

package com.ayoola.hospital.repository;

import com.ayoola.hospital.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    Patient findPatientById(long id);
    List<Patient> findPatientByLastName(String lastName );
    //List<Patient> findPatientById(long id);
}

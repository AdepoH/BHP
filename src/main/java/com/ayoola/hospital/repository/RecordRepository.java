package com.ayoola.hospital.repository;

import com.ayoola.hospital.model.Record;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends CrudRepository<Record, Long> {

    Optional<Record> findById(long id);
    List<Record> findByAppointmentDate(java.sql.Date appointmentDate);

}

package com.ayoola.hospital.repository;

import com.ayoola.hospital.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByFirstName(String firstName);
    boolean   existsByUsername(String username);
}

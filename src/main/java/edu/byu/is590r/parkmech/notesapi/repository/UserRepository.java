package edu.byu.is590r.parkmech.notesapi.repository;

import edu.byu.is590r.parkmech.notesapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findFirstById(Long id);
    Optional<User> findFirstByEmail(String email);
}
package edu.byu.is590r.parkmech.notesapi.service;

import edu.byu.is590r.parkmech.notesapi.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    User getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    User saveUser(User user);

    boolean validateUserByEmail(String email);
}
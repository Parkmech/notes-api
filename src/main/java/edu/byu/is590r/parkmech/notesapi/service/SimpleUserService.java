package edu.byu.is590r.parkmech.notesapi.service;

import edu.byu.is590r.parkmech.notesapi.model.User;
import edu.byu.is590r.parkmech.notesapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleUserService implements UserService {

    private String salt;
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        var user = userRepository.findFirstById((id));
        return user;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        var user = userRepository.findFirstByEmail(email);
        return user;
    }

    @Override
    public User saveUser(User user) {
        user.setCreatedAt(Instant.now());
        user.setPasswordHash(DigestUtils.sha256Hex(user.getPassword() + salt));
        return userRepository.save(user);
    }

    @Override
    public boolean validateUserByEmail(String email) {
        Optional<User> existingUser = userRepository.findFirstByEmail(email);
        return existingUser.isPresent() ? true : false;
    }

}
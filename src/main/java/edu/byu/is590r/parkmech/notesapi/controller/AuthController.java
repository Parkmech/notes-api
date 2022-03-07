package edu.byu.is590r.parkmech.notesapi.controller;

import edu.byu.is590r.parkmech.notesapi.auth.EncryptionUtils;
import edu.byu.is590r.parkmech.notesapi.model.User;
import edu.byu.is590r.parkmech.notesapi.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "AuthController", description = "Authentication Controller endpoint")
@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthController {

    private UserService userService;
    private HttpServletRequest httpServletRequest;

    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@RequestBody User user) {
        if (userService.validateUserByEmail(user.getEmail()))
        {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new User().setAlreadyExists(true));
        }
        var dbUser = userService.getUserByEmail(user.getEmail());
        String passwordHash = dbUser.get().getPasswordHash();
        String currentPasswordHash = EncryptionUtils.encryptString(user.getPassword());
        if(!passwordHash.equals(currentPasswordHash)) {

        }
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        var returnUser = userService.saveUser(user);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromRequestUri(httpServletRequest)
                        .queryParam("id={id}")
                        .buildAndExpand(returnUser.getId()).toUri())
                .body(returnUser);
    }
}
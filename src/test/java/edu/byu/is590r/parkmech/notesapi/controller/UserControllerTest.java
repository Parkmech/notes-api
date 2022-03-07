package edu.byu.is590r.parkmech.notesapi.controller;

import edu.byu.is590r.parkmech.notesapi.NotesApiApplication;
import edu.byu.is590r.parkmech.notesapi.model.User;
import edu.byu.is590r.parkmech.notesapi.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {NotesApiApplication.class, UserController.class, UserService.class})
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
        long someNum = 0;
        Mockito.when(userService.getUserById(someNum)).thenReturn(new User() {{
            setFirstName("Mock user name");
        }});
        var testName = userController.getUser(someNum);
        Assertions.assertEquals("Mock user name", Objects.requireNonNull(testName.getBody()).getFirstName());
    }
}
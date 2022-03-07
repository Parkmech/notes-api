package edu.byu.is590r.parkmech.notesapi.service;

import edu.byu.is590r.parkmech.notesapi.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.http.HttpServletRequest;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {UserService.class})
class DummyUserServiceTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private HttpServletRequest request;

    @Test
    void getUserName() {
        Mockito.when(request.getScheme()).thenReturn("http");
        var dummyUserService = new SimpleUserService("salt", userRepository);
        long testID = 0;
        var testResult = String.format("Hello, %s, from the UserService", testID);
        var result = dummyUserService.getUserById(testID);
        Assertions.assertEquals(testResult, result.getFirstName());
    }
}
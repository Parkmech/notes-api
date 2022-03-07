package edu.byu.is590r.parkmech.notesapi.config;

import edu.byu.is590r.parkmech.notesapi.repository.UserRepository;
import edu.byu.is590r.parkmech.notesapi.service.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.servlet.http.HttpServletRequest;

@Profile("test")
@Configuration
public class UserControllerTestConfiguration {

    @Bean
    public UserService userService() {
        return Mockito.mock(UserService.class);
    }

    @Bean
    public UserRepository userRepository() {
        return Mockito.mock(UserRepository.class);
    }

    @Bean
    public HttpServletRequest httpServletRequest() { return Mockito.mock(HttpServletRequest.class);}
}
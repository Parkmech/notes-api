package edu.byu.is590r.parkmech.notesapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "parkmech Notes API", version = "v1", description = "Notes API Application"))
public class NotesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesApiApplication.class, args);
    }
}

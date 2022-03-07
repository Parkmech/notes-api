package edu.byu.is590r.parkmech.notesapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"id", "created_at"})
@Table(name="user_authentication")

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "first name is required")
    @NonNull
    @Column(length = 50)
    private String firstName;

    @NotEmpty(message = "email is required")
    @NonNull
    @Column(unique = true, length = 100)
    private String email;

    @NotEmpty(message = "password_hash is required")
    @NonNull
    @Schema(hidden = true)
    private String passwordHash;

    @Schema(name = "password",
            required = true,
            example = "mypassword",
            accessMode = Schema.AccessMode.WRITE_ONLY)
    private transient String password;

    @Schema(name = "already_exists",
            example = "false",
            accessMode = Schema.AccessMode.WRITE_ONLY)
    private transient Boolean alreadyExists;

    private Instant createdAt;

}
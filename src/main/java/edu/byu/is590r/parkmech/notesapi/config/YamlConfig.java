package edu.byu.is590r.parkmech.notesapi.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("server")
public class YamlConfig {
    private String name;
    private String environment;
    private boolean enabled;
    private final List<String> servers = new ArrayList<>();

    // standard getters and setters
}
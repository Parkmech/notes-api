package edu.byu.is590r.parkmech.notesapi.config;


import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
public class StringPropConfig {

    @Bean(name = "env")
    @Profile("dev")
    public String getDevEnvironment() {
        return "dev";
    }

    @Bean(name = "env")
    @Profile("prod")
    public String getProdEnvironment() {
        return "prod";
    }

    @Bean(name = "urlScheme")
    @Profile("dev")
    public String getDevScheme() {
        return "https";
    }

    @Bean(name = "urlScheme")
    @Profile("prod")
    public String getProdScheme() {
        return "http";
    }

    @Bean(name = "urlScheme")
    public String getDefaultScheme() {
        return "http";
    }

    @Bean(name = "jwtSecret")
    public String getJwtSecret() {
        return System.getenv("JWT_SECRET");
    }

    @Bean(name = "jwtExpirationMilli")
    public int getJwtExpirationMilli() {
        return 24 * 60 * 60 * 1000;
    }

    @Bean(name = "salt")
    public String getDefaultSalt() {
        return System.getenv("SPRING_SALT");
    }

}

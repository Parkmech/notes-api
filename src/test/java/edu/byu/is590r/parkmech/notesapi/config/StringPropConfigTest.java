package edu.byu.is590r.parkmech.notesapi.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class StringPropConfigTest {

    StringPropConfig stringPropConfig = new StringPropConfig();
    @Test
    void getDevEnvironment() {
        var devEnv = stringPropConfig.getDevEnvironment();
        Assertions.assertEquals("dev", devEnv);
    }

    @Test
    void getProdEnvironment() {
        var prodEnv = stringPropConfig.getProdEnvironment();
        Assertions.assertEquals("prod", prodEnv);
    }
}
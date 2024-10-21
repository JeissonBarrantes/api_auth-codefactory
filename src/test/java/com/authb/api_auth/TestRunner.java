package com.authb.api_auth.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.authb.api_auth.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},  // Reportes generados
        monochrome = true  // Salida más legible en la consola
)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
public class CucumberTestRunner {
}

package com.authb.api_auth;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.authb.api_auth.stepdefinitions", "com.authb.api_auth.config"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        monochrome = true,
        publish = true
)
public class TestRunner {
}

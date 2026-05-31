package co.edu.udea.certificacion.auto.moduloprueba.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.edu.udea.certificacion.auto.moduloprueba.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

class DepositRunner {
}


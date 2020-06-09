package co.com.choucair.certification.EjercicioSoap.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static cucumber.api.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/SoapCalculator.feature"},
        glue = {"co.com.choucair.certification.EjercicioSoap.stepdefinitions"},
        snippets = CAMELCASE)
public class SoapRunnerTags {
}
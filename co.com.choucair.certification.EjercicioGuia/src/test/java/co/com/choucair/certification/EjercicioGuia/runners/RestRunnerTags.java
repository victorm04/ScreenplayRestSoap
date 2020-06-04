package co.com.choucair.certification.EjercicioGuia.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/RestCreateUser.feature",
        glue = {"co.com.choucair.certification.EjercicioGuia.stepdefinitions","co.com.choucair.certificacion.EjercicioGuia.utils"},
        snippets = SnippetType.CAMELCASE )
public class RestRunnerTags {
}

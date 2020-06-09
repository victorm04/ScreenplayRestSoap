package co.com.choucair.certification.EjercicioSoap.stepdefinitions;

import co.com.choucair.certification.EjercicioSoap.questions.LastResponseStatusCode;
import co.com.choucair.certification.EjercicioSoap.tasks.AddNumbers;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import java.util.List;

import static co.com.choucair.certification.EjercicioSoap.utils.enums.SoapService.BASE_URL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CalculatorStepdefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Victor").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("^you add two numbers$")
    public void youAddTwoNumbers(List<String> values) {
        theActorInTheSpotlight().attemptsTo(AddNumbers.with(values));
    }

    @Then("^I should see the response of server is (\\d+)$")
    public void iShouldSeeTheResponseOfServerIs(int code) {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(LastResponseStatusCode.is(code)));
    }
}

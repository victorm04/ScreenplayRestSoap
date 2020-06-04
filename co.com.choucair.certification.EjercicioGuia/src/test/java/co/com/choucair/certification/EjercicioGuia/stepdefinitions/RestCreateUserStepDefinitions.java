package co.com.choucair.certification.EjercicioGuia.stepdefinitions;

import co.com.choucair.certification.EjercicioGuia.models.ModelCreateUserRest;
import co.com.choucair.certification.EjercicioGuia.questions.LastResponseStatusCode;
import co.com.choucair.certification.EjercicioGuia.tasks.CreateUserRest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;

import static co.com.choucair.certification.EjercicioGuia.utils.Constant.VALUE;
import static co.com.choucair.certification.EjercicioGuia.utils.enums.RestService.BASE_URL;

public class RestCreateUserStepDefinitions {

    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Victor").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("^you create a user$")
    public void youCreateAUser(List<ModelCreateUserRest> modelCreateUserRest) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUserRest.with(modelCreateUserRest));
    }

    @Then("^I should see the user created$")
    public void iShouldSeeTheUserCreated() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(LastResponseStatusCode.is(VALUE)));
    }
}

package co.edu.udea.certificacion.auto.moduloprueba.stepdefinitions;

import co.edu.udea.certificacion.auto.moduloprueba.interactions.DepositWithDecimalValue;
import co.edu.udea.certificacion.auto.moduloprueba.interactions.DepositWithEmptyValue;
import co.edu.udea.certificacion.auto.moduloprueba.questions.DepositMessage;
import co.edu.udea.certificacion.auto.moduloprueba.questions.InvalidDepositMessage;
import co.edu.udea.certificacion.auto.moduloprueba.questions.ValidationDeposit;
import co.edu.udea.certificacion.auto.moduloprueba.tasks.MakeDeposit;
import co.edu.udea.certificacion.auto.moduloprueba.tasks.OpenTheBrowser;
import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class depositStepDefinition {

    @Managed
    public WebDriver driver;

    private Actor usuario;

    DepositInterface depositInterface = new DepositInterface();

    @Before
    public void config() {

        OnStage.setTheStage(new OnlineCast());

        usuario = OnStage.theActorCalled("usuario");

        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("estoy en la vista de depositos de XYZ Bank")
    public void estoyEnLaVistaDeDepositosDeXYZBank() {

        usuario.wasAbleTo(
                 OpenTheBrowser.on() );
    }

    @When("ingreso un monto mayor a 0")
    public void ingresoUnMontoMayorAO() {

        usuario.attemptsTo(
                MakeDeposit.withValue("100")
        );
    }

    @When("dejo el campo de monto vacio")
    public void dejoElCampoDeMontoVacio() {

        usuario.attemptsTo(
                DepositWithEmptyValue.tryDeposit()
        );
    }

    @When("ingreso un valor decimal")
    public void ingresoUnValorDecimal() {

        usuario.attemptsTo(
                DepositWithDecimalValue.tryDeposit()
        );
    }

    @Then("veo una notificacion indicando {string}")
    public void veoUnaNotificacionIndicando(String mensaje) {

        usuario.should(
                seeThat(
                        DepositMessage.value(),
                        Matchers.containsString(mensaje)
                )
        );
    }

    @Then("veo una notificacion indicando que el monto es obligatorio")
    public void veoUnaNotificacionIndicandoQueElMontoEsObligatorio() {

        usuario.should(
                seeThat(
                        InvalidDepositMessage.value(),
                        Matchers.containsString("Amount is required")
                )
        );
    }

    @Then("veo una notificacion indicando que el deposito fue realizado incorrectamente")
    public void veoUnaNotificacionIndicandoQueElDepositoFueRealizadoIncorrectamente() {

        usuario.should(
                seeThat(
                        ValidationDeposit.value(),
                        Matchers.containsString("Invalid amount")
                )
        );
    }
}




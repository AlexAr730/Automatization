package co.edu.udea.certificacion.auto.moduloprueba.stepdefinitions;

import co.edu.udea.certificacion.auto.moduloprueba.questions.AddCustomerMessage;
import co.edu.udea.certificacion.auto.moduloprueba.questions.ValidationAddCustomer;
import co.edu.udea.certificacion.auto.moduloprueba.tasks.AddCustomer;
import co.edu.udea.certificacion.auto.moduloprueba.tasks.OpenTheBrowser;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class addCustomerStepDefinition {

    @Managed
    public WebDriver driver;

    private Actor usuario;

    @Before
    public void config() {

        OnStage.setTheStage(new OnlineCast());

        usuario = OnStage.theActorCalled("usuario");

        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("estoy en la vista de agregar clientes de XYZ Bank")
    public void estoyEnLaVistaDeAgregarClientesDeXYZBank() {

        usuario.wasAbleTo(
                OpenTheBrowser.on()
        );
    }

    @When("ingreso un nombre, apellido y codigo postal validos")
    public void ingresoUnNombreApellidoYCodigoPostalValidos() {

        usuario.attemptsTo(
                AddCustomer.withData(
                        "Juan",
                        "Perez",
                        "050001"
                )
        );
    }

    @When("dejo el campo nombre vacio")
    public void dejoElCampoNombreVacio() {

        usuario.attemptsTo(
                AddCustomer.withData(
                        "",
                        "Perez",
                        "050001"
                )
        );
    }

    @When("dejo el campo apellido vacio")
    public void dejoElCampoApellidoVacio() {

        usuario.attemptsTo(
                AddCustomer.withData(
                        "Juan",
                        "",
                        "050001"
                )
        );
    }

    @When("dejo el campo codigo postal vacio")
    public void dejoElCampoCodigoPostalVacio() {

        usuario.attemptsTo(
                AddCustomer.withData(
                        "Juan",
                        "Perez",
                        ""
                )
        );
    }


    @Then("veo una notificacion de cliente agregado indicando {string}")
    public void veoUnaNotificacionDeClienteAgregadoIndicando(String mensaje) {

        usuario.should(
                seeThat(
                        AddCustomerMessage.value(),
                        Matchers.containsString(mensaje)
                )
        );
    }


    @Then("veo una notificacion indicando que el nombre es obligatorio")
    public void veoUnaNotificacionIndicandoQueElNombreEsObligatorio() {

        usuario.should(
                seeThat(
                        ValidationAddCustomer.value(),
                        Matchers.containsString("Completa este campo")
                )
        );
    }

    @Then("veo una notificacion indicando que el apellido es obligatorio")
    public void veoUnaNotificacionIndicandoQueElApellidoEsObligatorio() {

        usuario.should(
                seeThat(
                        ValidationAddCustomer.value(),
                        Matchers.containsString("Completa este campo")
                )
        );
    }

    @Then("veo una notificacion indicando que el codigo postal es obligatorio")
    public void veoUnaNotificacionIndicandoQueElCodigoPostalEsObligatorio() {

        usuario.should(
                seeThat(
                        ValidationAddCustomer.value(),
                        Matchers.containsString("Completa este campo")
                )
        );
    }
}


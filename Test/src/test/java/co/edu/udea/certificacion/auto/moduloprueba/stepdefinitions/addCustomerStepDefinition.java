package co.edu.udea.certificacion.auto.moduloprueba.stepdefinitions;

import co.edu.udea.certificacion.auto.moduloprueba.models.Customer;
import co.edu.udea.certificacion.auto.moduloprueba.questions.AddCustomerMessage;
import co.edu.udea.certificacion.auto.moduloprueba.questions.ValidationAddCustomer;
import co.edu.udea.certificacion.auto.moduloprueba.tasks.AddCustomer;
import co.edu.udea.certificacion.auto.moduloprueba.tasks.OpenTheBrowser;
import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.AddCustomerInterface;

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

    private Actor manager;

    @Before
    public void config() {

        OnStage.setTheStage(new OnlineCast());

        manager = OnStage.theActorCalled("manager");

        manager.can(BrowseTheWeb.with(driver));
    }

    private Customer customer(
            String firstName,
            String lastName,
            String postCode
    ) {
        return new Customer(
                firstName,
                lastName,
                postCode
        );
    }

    @Given("estoy en la vista de agregar clientes de XYZ Bank")
    public void estoyEnLaVistaDeAgregarClientesDeXYZBank() {

        manager.wasAbleTo(
                OpenTheBrowser.on()
        );
    }

    @When("ingreso un nombre, apellido y codigo postal validos")
    public void ingresoUnNombreApellidoYCodigoPostalValidos() {

        manager.attemptsTo(
                AddCustomer.withData(
                        customer(
                                "Juan",
                                "Perez",
                                "050001"
                        )
                )
        );
    }

    @When("dejo el campo nombre vacio")
    public void dejoElCampoNombreVacio() {

        manager.attemptsTo(
                AddCustomer.withData(
                        customer(
                                "",
                                "Perez",
                                "050001"
                        )
                )
        );
    }

    @When("dejo el campo apellido vacio")
    public void dejoElCampoApellidoVacio() {

        manager.attemptsTo(
                AddCustomer.withData(
                        customer(
                                "Juan",
                                "",
                                "050001"
                        )
                )
        );
    }

    @When("dejo el campo codigo postal vacio")
    public void dejoElCampoCodigoPostalVacio() {

        manager.attemptsTo(
                AddCustomer.withData(
                        customer(
                                "Juan",
                                "Perez",
                                ""
                        )
                )
        );
    }

    @Then("veo una notificacion de cliente agregado indicando {string}")
    public void veoUnaNotificacionDeClienteAgregadoIndicando(String mensaje) {

        manager.should(
                seeThat(
                        AddCustomerMessage.value(),
                        Matchers.containsString(mensaje)
                )
        );
    }

    @Then("veo una notificacion indicando que el nombre es obligatorio")
    public void veoUnaNotificacionIndicandoQueElNombreEsObligatorio() {

        manager.should(
                seeThat(
                        ValidationAddCustomer.of(
                                AddCustomerInterface.FIRST_NAME_INPUT
                        ),
                        Matchers.containsString("Completa este campo")
                )
        );
    }

    @Then("veo una notificacion indicando que el apellido es obligatorio")
    public void veoUnaNotificacionIndicandoQueElApellidoEsObligatorio() {

        manager.should(
                seeThat(
                        ValidationAddCustomer.of(
                                AddCustomerInterface.LAST_NAME_INPUT
                        ),
                        Matchers.containsString("Completa este campo")
                )
        );
    }

    @Then("veo una notificacion indicando que el codigo postal es obligatorio")
    public void veoUnaNotificacionIndicandoQueElCodigoPostalEsObligatorio() {

        manager.should(
                seeThat(
                        ValidationAddCustomer.of(
                                AddCustomerInterface.POST_CODE_INPUT
                        ),
                        Matchers.containsString("Completa este campo")
                )
        );
    }
}
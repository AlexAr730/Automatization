package co.edu.udea.certificacion.auto.moduloprueba.tasks;

import co.edu.udea.certificacion.auto.moduloprueba.interactions.AddCustomerData;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddCustomer implements Task {

    private final String firstName;
    private final String lastName;
    private final String postCode;

    public AddCustomer(String firstName, String lastName, String postCode) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                AddCustomerData.withInformation(
                        firstName,
                        lastName,
                        postCode
                )
        );
    }

    public static AddCustomer withData(
            String firstName,
            String lastName,
            String postCode
    ) {

        return instrumented(
                AddCustomer.class,
                firstName,
                lastName,
                postCode
        );
    }
}


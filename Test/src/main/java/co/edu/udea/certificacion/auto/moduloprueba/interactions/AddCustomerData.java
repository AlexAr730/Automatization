package co.edu.udea.certificacion.auto.moduloprueba.interactions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.AddCustomerInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddCustomerData implements Interaction {

    private final String firstName;
    private final String lastName;
    private final String postCode;

    public AddCustomerData(
            String firstName,
            String lastName,
            String postCode
    ) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(AddCustomerInterface.BANK_MANAGER_LOGIN_BUTTON),

                Click.on(AddCustomerInterface.ADD_CUSTOMER_BUTTON)
        );

        if (firstName != null && !firstName.isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(firstName)
                            .into(AddCustomerInterface.FIRST_NAME_INPUT)
            );
        }

        if (lastName != null && !lastName.isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(lastName)
                            .into(AddCustomerInterface.LAST_NAME_INPUT)
            );
        }

        if (postCode != null && !postCode.isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(postCode)
                            .into(AddCustomerInterface.POST_CODE_INPUT)
            );
        }

        actor.attemptsTo(
                Click.on(AddCustomerInterface.CONFIRM_ADD_CUSTOMER_BUTTON)
        );
    }

    public static AddCustomerData withInformation(
            String firstName,
            String lastName,
            String postCode
    ) {

        return instrumented(
                AddCustomerData.class,
                firstName,
                lastName,
                postCode
        );
    }
}


package co.edu.udea.certificacion.auto.moduloprueba.interactions;

import co.edu.udea.certificacion.auto.moduloprueba.models.Customer;
import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.AddCustomerInterface;
import co.edu.udea.certificacion.auto.moduloprueba.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddCustomerData implements Interaction {

    private final Customer customer;

    public AddCustomerData(Customer customer) {
        this.customer = customer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(AddCustomerInterface.BANK_MANAGER_LOGIN_BUTTON)
        );
        Wait.aLittleBitTime(500);
     

        actor.attemptsTo(
                Click.on(AddCustomerInterface.ADD_CUSTOMER_BUTTON)
        );
        Wait.aLittleBitTime(500);

        if (customer.getFirstName() != null &&
                !customer.getFirstName().isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(customer.getFirstName())
                            .into(AddCustomerInterface.FIRST_NAME_INPUT)
            );
            Wait.aLittleBitTime(500);
        }

        if (customer.getLastName() != null &&
                !customer.getLastName().isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(customer.getLastName())
                            .into(AddCustomerInterface.LAST_NAME_INPUT)
            );
            Wait.aLittleBitTime(500);
        }

        if (customer.getPostCode() != null &&
                !customer.getPostCode().isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(customer.getPostCode())
                            .into(AddCustomerInterface.POST_CODE_INPUT)
            );
            Wait.aLittleBitTime(500);
        }

        actor.attemptsTo(
                Click.on(AddCustomerInterface.CONFIRM_ADD_CUSTOMER_BUTTON)
        );
    }

    public static AddCustomerData withInformation(Customer customer) {
        return instrumented(AddCustomerData.class, customer);
    }
}
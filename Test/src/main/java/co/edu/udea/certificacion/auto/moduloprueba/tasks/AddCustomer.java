package co.edu.udea.certificacion.auto.moduloprueba.tasks;

import co.edu.udea.certificacion.auto.moduloprueba.interactions.AddCustomerData;
import co.edu.udea.certificacion.auto.moduloprueba.models.Customer;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddCustomer implements Task {

    private final Customer customer;

    public AddCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                AddCustomerData.withInformation(customer)
        );
    }

    public static AddCustomer withData(Customer customer) {
        return instrumented(AddCustomer.class, customer);
    }
}
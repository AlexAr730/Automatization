package co.edu.udea.certificacion.auto.moduloprueba.interactions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DepositValue implements Interaction {

    private final String value;

    public DepositValue(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(DepositInterface.CUSTOMER_LOGIN_BUTTON)
        );
        sleep(1000);

        actor.attemptsTo(
                SelectFromOptions.byVisibleText("Harry Potter")
                        .from(DepositInterface.USER_SELECT)
        );
        sleep(1000);

        actor.attemptsTo(
                Click.on(DepositInterface.LOGIN_BUTTON)
        );
        sleep(1000);

        actor.attemptsTo(
                Click.on(DepositInterface.DEPOSIT_BUTTON)
        );
        sleep(1000);

        if (value != null && !value.isEmpty()) {

            actor.attemptsTo(
                    Enter.theValue(value)
                            .into(DepositInterface.AMOUNT_INPUT)
            );
            sleep(1000);
        }

        actor.attemptsTo(
                Click.on(DepositInterface.CONFIRM_DEPOSIT_BUTTON)
        );
        sleep(1000);
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static DepositValue withAmount(String value) {
        return instrumented(DepositValue.class, value);
    }
}
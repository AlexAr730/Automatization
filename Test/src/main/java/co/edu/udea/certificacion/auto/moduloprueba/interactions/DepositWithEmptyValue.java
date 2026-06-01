package co.edu.udea.certificacion.auto.moduloprueba.interactions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DepositWithEmptyValue implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(DepositInterface.CUSTOMER_LOGIN_BUTTON),

                SelectFromOptions.byVisibleText("Harry Potter").from(DepositInterface.USER_SELECT),

                Click.on(DepositInterface.LOGIN_BUTTON),

                Click.on(DepositInterface.DEPOSIT_BUTTON),

                Click.on(DepositInterface.CONFIRM_DEPOSIT_BUTTON)
        );
    }

    public static DepositWithEmptyValue tryDeposit() {
        return instrumented(DepositWithEmptyValue.class);
    }
}

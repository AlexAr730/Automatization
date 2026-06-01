package co.edu.udea.certificacion.auto.moduloprueba.tasks;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakeDeposit implements Task {

    private final String value;

    public MakeDeposit(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Click.on(DepositInterface.CUSTOMER_LOGIN_BUTTON),

                SelectFromOptions.byVisibleText("Harry Potter").from(DepositInterface.USER_SELECT),

                Click.on(DepositInterface.LOGIN_BUTTON),

                Click.on(DepositInterface.DEPOSIT_BUTTON),

                Enter.theValue(value)
                        .into(DepositInterface.AMOUNT_INPUT),

                Click.on(DepositInterface.CONFIRM_DEPOSIT_BUTTON)
        );
    }

    public static MakeDeposit withValue(String value) {
        return instrumented(MakeDeposit.class, value);
    }
}


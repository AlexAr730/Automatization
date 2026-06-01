package co.edu.udea.certificacion.auto.moduloprueba.tasks;

import co.edu.udea.certificacion.auto.moduloprueba.interactions.DepositValue;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakeDeposit implements Task {

    private final String value;

    public MakeDeposit(String value) {
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                DepositValue.withAmount(value)
        );
    }

    public static MakeDeposit withValue(String value) {
        return instrumented(MakeDeposit.class, value);
    }
}
package co.edu.udea.certificacion.auto.moduloprueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheBrowser implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.url("pages:xyzbank")
        );
    }

    public static OpenTheBrowser on() {
        return instrumented(OpenTheBrowser.class);
    }
}


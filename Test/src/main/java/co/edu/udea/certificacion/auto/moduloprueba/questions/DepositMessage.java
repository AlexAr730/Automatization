package co.edu.udea.certificacion.auto.moduloprueba.questions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DepositMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return DepositInterface.SUCCESS_MESSAGE
                .resolveFor(actor)
                .getText();
    }

    public static DepositMessage value() {
        return new DepositMessage();
    }
}


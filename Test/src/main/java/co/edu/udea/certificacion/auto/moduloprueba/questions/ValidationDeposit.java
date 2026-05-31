package co.edu.udea.certificacion.auto.moduloprueba.questions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationDeposit implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return DepositInterface.SUCCESS_MESSAGE
                .resolveFor(actor)
                .getText();
    }

    public static ValidationDeposit value() {
        return new ValidationDeposit();
    }
}


package co.edu.udea.certificacion.auto.moduloprueba.questions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.DepositInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationDeposit implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        String mensaje = DepositInterface.AMOUNT_INPUT
                .resolveFor(actor)
                .getAttribute("validationMessage");

        System.out.println("Mensaje de validación: " + mensaje);

        return mensaje;
    }

    public static ValidationDeposit value() {
        return new ValidationDeposit();
    }
}

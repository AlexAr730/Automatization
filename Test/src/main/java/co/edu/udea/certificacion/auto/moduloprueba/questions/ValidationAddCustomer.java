package co.edu.udea.certificacion.auto.moduloprueba.questions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.AddCustomerInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationAddCustomer implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        String mensaje = AddCustomerInterface.FIRST_NAME_INPUT
                .resolveFor(actor)
                .getAttribute("validationMessage");

        System.out.println("Mensaje de validación: " + mensaje);

        return mensaje;
    }

    public static ValidationAddCustomer value() {
        return new ValidationAddCustomer();
    }
}


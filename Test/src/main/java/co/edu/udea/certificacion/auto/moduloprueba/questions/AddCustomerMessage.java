package co.edu.udea.certificacion.auto.moduloprueba.questions;

import co.edu.udea.certificacion.auto.moduloprueba.userinterfaces.AddCustomerInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AddCustomerMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        return AddCustomerInterface.SUCCESS_MESSAGE
                .resolveFor(actor)
                .getText();
    }

    public static AddCustomerMessage value() {
        return new AddCustomerMessage();
    }
}

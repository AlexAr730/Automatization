package co.edu.udea.certificacion.auto.moduloprueba.questions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidationAddCustomer implements Question<String> {

    private final Target campo;

    public ValidationAddCustomer(Target campo) {
        this.campo = campo;
    }

    @Override
    public String answeredBy(Actor actor) {

        String mensaje = campo.resolveFor(actor)
                .getAttribute("validationMessage");

        System.out.println("Mensaje de validación: " + mensaje);

        return mensaje;
    }

    public static ValidationAddCustomer of(Target campo) {
        return new ValidationAddCustomer(campo);
    }
}



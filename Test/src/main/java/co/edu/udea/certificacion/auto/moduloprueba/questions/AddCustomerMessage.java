package co.edu.udea.certificacion.auto.moduloprueba.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AddCustomerMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        WebDriver driver = Serenity.getDriver();

        Alert alert = driver.switchTo().alert();

        String mensaje = alert.getText();

        alert.accept();

        return mensaje;
    }

    public static AddCustomerMessage value() {
        return new AddCustomerMessage();
    }
}


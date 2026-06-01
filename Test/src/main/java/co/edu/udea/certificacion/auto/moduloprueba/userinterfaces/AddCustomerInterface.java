package co.edu.udea.certificacion.auto.moduloprueba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AddCustomerInterface extends PageObject {

    public static final Target BANK_MANAGER_LOGIN_BUTTON = Target.the(
            "Boton bank manager login")
            .located(By.xpath("//button[contains(text(),'Bank Manager Login')]"));

    public static final Target ADD_CUSTOMER_BUTTON = Target.the(
            "Boton add customer")
            .located(By.xpath("//button[contains(text(),'Add Customer')]"));

    public static final Target FIRST_NAME_INPUT = Target.the(
            "Campo para ingresar el nombre")
            .located(By.xpath("//input[@placeholder='First Name']"));

    public static final Target LAST_NAME_INPUT = Target.the(
            "Campo para ingresar el apellido")
            .located(By.xpath("//input[@placeholder='Last Name']"));

    public static final Target POST_CODE_INPUT = Target.the(
            "Campo para ingresar el codigo postal")
            .located(By.xpath("//input[@placeholder='Post Code']"));

    public static final Target CONFIRM_ADD_CUSTOMER_BUTTON = Target.the(
            "Boton confirmar agregar cliente")
            .located(By.xpath("//button[@type='submit']"));


}

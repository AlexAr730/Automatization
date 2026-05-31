package co.edu.udea.certificacion.auto.moduloprueba.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DepositInterface extends PageObject {

    public static final Target CUSTOMER_LOGIN_BUTTON = Target.the(
            "Boton customer login")
            .located(By.xpath("//button[contains(text(),'Customer Login')]"));

    public static final Target USER_SELECT = Target.the(
            "Lista de usuarios")
            .located(By.id("userSelect"));

    public static final Target LOGIN_BUTTON = Target.the(
            "Boton login")
            .located(By.xpath("//button[contains(text(),'Login')]"));

    public static final Target DEPOSIT_BUTTON = Target.the(
            "Boton deposit")
            .located(By.xpath("//button[contains(text(),'Deposit')]"));

    public static final Target AMOUNT_INPUT = Target.the(
            "Campo para ingresar el monto")
            .located(By.xpath("//input[@placeholder='amount']"));

    public static final Target CONFIRM_DEPOSIT_BUTTON = Target.the(
            "Boton confirmar deposito")
            .located(By.xpath("//button[@type='submit']"));

    public static final Target SUCCESS_MESSAGE = Target.the(
            "Mensaje de deposito exitoso")
            .located(By.xpath("//span[contains(text(),'Deposit Successful')]"));
}



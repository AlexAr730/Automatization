package co.edu.udea.certificacion.auto.moduloprueba.models;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String postCode;

    public Customer(
            String firstName,
            String lastName,
            String postCode
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postCode = postCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostCode() {
        return postCode;
    }
}
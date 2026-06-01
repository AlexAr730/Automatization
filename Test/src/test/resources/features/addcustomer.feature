Feature: Agregar clientes en XYZ Bank
  Como bank manager
  Necesito agregar nuevos clientes
  Para registrar usuarios en el banco

  Scenario: Agregar cliente correctamente
    Given estoy en la vista de agregar clientes de XYZ Bank
    When ingreso un nombre, apellido y codigo postal validos
    Then veo una notificacion de cliente agregado indicando "Customer added successfully"

  Scenario: Campo nombre vacio
    Given estoy en la vista de agregar clientes de XYZ Bank
    When dejo el campo nombre vacio
    Then veo una notificacion indicando que el nombre es obligatorio

  Scenario: Campo apellido vacio
    Given estoy en la vista de agregar clientes de XYZ Bank
    When dejo el campo apellido vacio
    Then veo una notificacion indicando que el apellido es obligatorio

  Scenario: Campo codigo postal vacio
    Given estoy en la vista de agregar clientes de XYZ Bank
    When dejo el campo codigo postal vacio
    Then veo una notificacion indicando que el codigo postal es obligatorio



Feature: Realizar depositos en XYZ Bank
  Como usuario logueado
  Necesito realizar depositos en mi cuenta
  Para aumentar mi balance disponible

  Scenario: Deposito exitoso
    Given estoy en la vista de depositos de XYZ Bank
    When ingreso un monto mayor a 0
    Then veo una notificacion indicando "Deposit Successful"

  Scenario: Campo de deposito vacio
    When dejo el campo de monto vacio
    Then veo una notificacion indicando que el monto es obligatorio

  Scenario: Deposito con valor decimal
    When ingreso un valor decimal
    Then veo una notificacion indicando que el deposito fue realizado incorrectamente


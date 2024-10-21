Feature: Registro de usuarios

  Como usuario nuevo
  Quiero registrarme en la plataforma
  Para poder acceder a los servicios.

  Background:
    Given el servicio de registro está disponible

  @SmokeTest
  Scenario: Registro exitoso con todos los campos obligatorios
    When ingreso los siguientes datos
      | id           | idType | city | gender | role | identificationNumber | firstName | lastName | birthDate  | phoneNumber  | email                 | password  | avatarUrl        | address         |
      | 1            | 1      | 1    | 1      | 1    | 123456789            | Juan      | Perez    | 1990-01-01 | 1234567890   | juan.perez@mail.com    | password1 | /avatars/juan.png | Calle Falsa 123 |
    And autorizo al sistema a acceder a mi información
    And hago clic en "Registrarse"
    Then el usuario debería estar presente en la base de datos


  @SmokeTest
  Scenario: Intento de registro con un correo ya registrado
    Given el servicio de registro está disponible
    And ingreso los siguientes datos
      | id           | idType | city | gender | role | identificationNumber | firstName | lastName | birthDate  | phoneNumber  | email                 | password  | avatarUrl        | address         |
      | 2            | 1      | 1    | 1      | 1    | 987654321            | Maria     | Gomez    | 1992-02-02 | 0987654321   | juan.perez@mail.com    | password2 | /avatars/maria.png | Calle Verdadera 456 |
    And autorizo al sistema a acceder a mi información
    When intento registrarme
    Then el sistema muestra un mensaje de error
    And el usuario no debería estar presente en la base de datos
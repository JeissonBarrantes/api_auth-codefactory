package com.authb.api_auth.stepdefinitions;

import com.authb.api_auth.dto.UserDto;
import com.authb.api_auth.entity.User;
import com.authb.api_auth.service.UserService;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegistroStepDefinitions {

    @Autowired
    private UserService userService;

    private UserDto userDto;
    private User registeredUser;

    @Given("el servicio de registro está disponible")
    public void elServicioDeRegistroEstaDisponible() {
        Assert.assertNotNull(userService);
    }

    @When("ingreso los siguientes datos")
    public void ingresoLosSiguientesDatos(io.cucumber.datatable.DataTable dataTable) {
        // Mapear los datos ingresados a UserDto
        var userData = dataTable.asMaps().get(0); // Obtener el primer set de datos

        userDto = new UserDto();
        userDto.setId(Long.parseLong(userData.get("id")));
        userDto.setIdType(Integer.parseInt(userData.get("idType")));
        userDto.setCity(Integer.parseInt(userData.get("city")));
        userDto.setGender(Integer.parseInt(userData.get("gender")));
        userDto.setRole(Integer.parseInt(userData.get("role")));
        userDto.setIdentificationNumber(userData.get("identificationNumber"));
        userDto.setFirstName(userData.get("firstName"));
        userDto.setLastName(userData.get("lastName"));
        userDto.setBirthDate(userData.get("birthDate"));
        userDto.setPhoneNumber(userData.get("phoneNumber"));
        userDto.setEmail(userData.get("email"));
        userDto.setPassword(userData.get("password"));
        userDto.setAvatarUrl(userData.get("avatarUrl"));
        userDto.setAddress(userData.get("address"));
    }

    @And("autorizo al sistema a acceder a mi información")
    public void autorizoAlSistemaAAccederAMiInformacion() {
        // Supongamos que esto es implícito en la lógica de negocio y no requiere más implementación
        System.out.println("Usuario autoriza al sistema a acceder a su información.");
    }

    @And("hago clic en {string}")
    public void hagoClicEn(String button) {
        // Suponiendo que esto simula el evento de hacer clic en el botón de registro
        registeredUser = userService.SignUp(userDto);
    }

    @Then("el sistema confirma el registro mostrando un mensaje de éxito")
    public void elSistemaConfirmaElRegistroMostrandoUnMensajeDeExito() {
        // Validar que el usuario haya sido registrado correctamente
        Assert.assertNotNull(registeredUser);
        Assert.assertEquals(userDto.getEmail(), registeredUser.getEmail());
        System.out.println("Registro exitoso: " + registeredUser.getEmail());
    }
}

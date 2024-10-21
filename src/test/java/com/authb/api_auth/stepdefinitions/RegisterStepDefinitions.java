package com.authb.api_auth.stepdefinitions;

import com.authb.api_auth.dto.UserDto;
import com.authb.api_auth.entity.User;
import com.authb.api_auth.repository.UserRepository;
import com.authb.api_auth.service.UserService;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Transactional
public class RegisterStepDefinitions {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UserDto userDto;
    private User registeredUser;
    private Exception registrationException;

    @Given("el servicio de registro está disponible")
    public void elServicioDeRegistroEstaDisponible() {
        Assert.assertNotNull(userService);
    }

    @When("ingreso los siguientes datos")
    public void ingresoLosSiguientesDatos(io.cucumber.datatable.DataTable dataTable) {
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
        System.out.println("Usuario autoriza al sistema a acceder a su información.");
    }

    @And("hago clic en {string}")
    public void hagoClicEn(String button) {
        registeredUser = userService.SignUp(userDto);
    }

    @Then("el usuario debería estar presente en la base de datos")
    public void elUsuarioDeberiaEstarPresenteEnLaBaseDeDatos() {
        Assert.assertNotNull(registeredUser);
        Assert.assertEquals(userDto.getEmail(), registeredUser.getEmail());

        Assert.assertTrue(passwordEncoder.matches(userDto.getPassword(), registeredUser.getPassword()));
        System.out.println("Registro exitoso: " + registeredUser.getEmail());

    }

    @When("intento registrarme")
    public void intentoRegistrarme() {
        try {
            registeredUser = userService.SignUp(userDto);
        } catch (Exception e) {
            registrationException  = e;
        }
    }

    @Then("el sistema muestra un mensaje de error")
    public void elSistemaMuestraUnMensajeDeError() {
        Assert.assertNotNull(registrationException);
        System.out.println("Se lanzó una excepción: " + registrationException.getMessage());
    }

    @And("el usuario no debería estar presente en la base de datos")
    public void elUsuarioNoDeberiaEstarPresenteEnLaBaseDeDatos() {
        User existingUser = userRepository.findFirstByEmail(userDto.getEmail()).orElse(null);
        Assert.assertNull(existingUser);
    }

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }
}

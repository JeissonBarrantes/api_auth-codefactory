package com.authb.api_auth;

import com.authb.api_auth.controller.UserResolver;
import com.authb.api_auth.dto.AuthenticationRequest;
import com.authb.api_auth.dto.UserDto;
import com.authb.api_auth.entity.Role;
import com.authb.api_auth.entity.User;
import com.authb.api_auth.repository.RoleRepository;
import com.authb.api_auth.repository.UserRepository;
import com.authb.api_auth.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApiAuthApplicationTests {

	@Autowired
	UserResolver userResolver;
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	private User user;

	@BeforeEach
	void setUp() {

		Role role = new Role();
		role.setId(3L);
		role.setName("Admin");
		roleRepository.save(role);

		Optional<Role> optionalRole = roleRepository.findById(3L);
		if (optionalRole.isEmpty()) {
			role.setId(3L);
			role.setName("Admin");
			roleRepository.save(role);
			System.out.println("Rol creado: " + role);
		} else {
			System.out.println("El rol ya existe: " + optionalRole.get());
		}

		// Crea un usuario de prueba
		UserDto userDto = new UserDto(
				null,
				1, // idType
				1, // city
				1, // gender
				3, // role
				"123456789", // identificación
				"Santiago", // nombre
				"Correa", // apellido
				"2000-05-07", // fecha de nacimiento
				"1234567890", // teléfono
				"prueba1@udea.edu.co", // email
				"password123", // contraseña
				null, // URL del avatar
				"Dirección 123" // dirección
		);

		user = userResolver.signUp(userDto); // Asegúrate de que esto funcione correctamente
	}

	@Test
	void createAdminUser() {
		// Primero, crea un nuevo rol de administrador si no existe (asegúrate de que el ID corresponda al rol de admin)
		Role adminRole = roleRepository.findById(3L).orElseThrow(() -> new RuntimeException("Admin role not found"));

		// Luego, crea el DTO para el usuario
		UserDto adminUserDto = new UserDto(
                adminRole.getId(), // ID se generará automáticamente
                null, // idType
                1, // city
                1, // gender
                1, // Asigna el rol de admin
                "123456789", // identificación
                "Admin", // nombre
                "User", // apellido
                "2000-01-01", // fecha de nacimiento
                "1234567890", // número de teléfono
                "admin@example.com", // email
                "password123", // contraseña
                null, // avatarUrl
                "Admin Address" // dirección
                );

		// Crea el usuario a través del resolver
		User adminUser = userResolver.signUp(adminUserDto);

		// Verifica que el usuario se creó correctamente
		assertNotNull(adminUser);
		assertEquals(adminUserDto.getEmail(), adminUser.getEmail());

		// Limpieza
		userRepository.delete(adminUser);
	}


	@AfterEach
	void cleanUp(){
		if (user != null) {
			userRepository.delete(user);
		}
	}

	@Test
	void testRoleCreation() {
		Role role = new Role();
		role.setId(3L);
		role.setName("Admin");
		roleRepository.save(role);

		Optional<Role> fetchedRole = roleRepository.findById(3L);
		assertNotNull(fetchedRole.orElse(null), "El rol con ID 3 debería existir en la base de datos después de la creación.");
	}


	@Test
	void successfulSingUp(){
		assertEquals("prueba1@udea.edu.co", user.getEmail());
	}

	@Test
	void successfulSignIn() {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("prueba1@udea.edu.co", "password123");
		assertNotNull(userResolver.signIn(authenticationRequest));
	}

	@Test
	void adminRol() {
		// Verifica que el rol existe antes de hacer la modificación
		Optional<Role> optionalRole = roleRepository.findById(3L);
		assertNotNull(optionalRole.orElse(null), "El rol con ID 3 debería existir en la base de datos.");

		// Cambia el rol y verifica que se haya modificado correctamente
		Role modifiedRole = userResolver.modifyRole("prueba1@udea.edu.co", 3L).getRole();
		assertNotNull(modifiedRole, "El rol modificado no debería ser nulo.");
		assertEquals(3L, modifiedRole.getId(), "El ID del rol modificado debería ser 3.");
	}

	/*@Test
	void adminRol(){
		assertEquals(roleRepository.findById(Long.parseLong("3")).get().getId(),
				userResolver.modifyRole("prueba1@udea.edu.co", Long.parseLong("3")).getRole().getId());
	}*/

}

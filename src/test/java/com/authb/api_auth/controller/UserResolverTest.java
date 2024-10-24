package com.authb.api_auth.controller;

import com.authb.api_auth.dto.AuthenticationRequest;
import com.authb.api_auth.dto.UserDto;
import com.authb.api_auth.entity.Role;
import com.authb.api_auth.entity.User;
import com.authb.api_auth.repository.UserRepository;
import com.authb.api_auth.service.UserService;
import com.authb.api_auth.util.JwtUtil;
import graphql.GraphQLException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserResolverTest {

    @Mock
    private UserService userService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserResolver userResolver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSignUp() {
        // Arrange
        UserDto userDto = new UserDto();
        User expectedUser = new User();
        when(userService.SignUp(any(UserDto.class))).thenReturn(expectedUser);

        // Act
        User result = userResolver.signUp(userDto);

        // Assert
        assertNotNull(result);
        assertEquals(expectedUser, result);
        verify(userService, times(1)).SignUp(any(UserDto.class));
    }

    @Test
    void testSignIn_Success() throws Exception {
        // Arrange
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("test@example.com", "password");
        authenticationRequest.setEmail("test@example.com");
        authenticationRequest.setPassword("password");

        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn("test@example.com");

        User user = new User();
        user.setId(1L);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
        when(userService.loadUserByUsername(authenticationRequest.getEmail())).thenReturn(userDetails);
        when(userRepository.findFirstByEmail(authenticationRequest.getEmail())).thenReturn(java.util.Optional.of(user));
        when(jwtUtil.generateToken(userDetails.getUsername(), user.getId())).thenReturn("jwtToken");

        // Act
        String token = userResolver.signIn(authenticationRequest);

        // Assert
        assertNotNull(token);
        assertEquals("jwtToken", token);
    }

    @Test
    void testSignIn_InvalidCredentials() {
        // Arrange
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("test@example.com", "password");
        authenticationRequest.setEmail("test@example.com");
        authenticationRequest.setPassword("wrongPassword");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Invalid credentials"));

        // Act & Assert (combined as the action throws an exception)
        assertThrows(GraphQLException.class, () -> userResolver.signIn(authenticationRequest));
    }

    @Test
    void testUserById() {
        // Arrange
        User expectedUser = new User();
        expectedUser.setId(1L);

        when(userService.findById(1L)).thenReturn(expectedUser);

        // Act
        User result = userResolver.userById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(expectedUser, result);
    }

    @Test
    void testUserByEmail() {
        // Arrange
        User expectedUser = new User();
        expectedUser.setEmail("test@example.com");

        when(userService.findByEmail("test@example.com")).thenReturn(expectedUser);

        // Act
        User result = userResolver.userByEmail("test@example.com");

        // Assert
        assertNotNull(result);
        assertEquals(expectedUser, result);
    }

    /*@Test
    void testModifyRole() {
        // Arrange
        User user = new User();
        user.setEmail("test@example.com");

        Role role = new Role();
        role.setId(1L);

        when(userService.findByEmail("test@example.com")).thenReturn(user);
        when(com.authb.api_auth.service.RolService.findById(1L)).thenReturn(role);

        // Act
        User result = userResolver.modifyRole("test@example.com", 1L);

        // Assert
        assertNotNull(result);
        assertEquals(role, result.getRole());
    }*/
}

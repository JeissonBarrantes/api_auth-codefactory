package com.authb.api_auth.service;

import com.authb.api_auth.dto.RoleDto;
import com.authb.api_auth.entity.Permission;
import com.authb.api_auth.entity.Role;
import com.authb.api_auth.repository.PermissionRepository;
import com.authb.api_auth.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RolServiceTest {

    @Mock
    private PermissionRepository permissionRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RolService rolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testToRoleDto() {
        // Arrange
        Permission permission = new Permission();
        permission.setName("READ_PRIVILEGE");

        Set<Permission> permissions = new HashSet<>();
        permissions.add(permission);

        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        role.setDescription("Administrator role");
        role.setPermissions(permissions);

        // Act
        RoleDto roleDto = RolService.toRoleDto(role);

        // Assert
        assertNotNull(roleDto);
        assertEquals(1L, roleDto.getId());
        assertEquals("ADMIN", roleDto.getName());
        assertEquals("Administrator role", roleDto.getDescription());
        assertTrue(roleDto.getPermissionNames().contains("READ_PRIVILEGE"));
    }

    @Test
    void testToRole() {
        // Arrange
        RoleDto roleDto = new RoleDto(1L, "ADMIN", "Administrator role", Set.of("READ_PRIVILEGE"));
        Permission permission = new Permission();
        permission.setName("READ_PRIVILEGE");

        when(permissionRepository.findByName("READ_PRIVILEGE")).thenReturn(Optional.of(permission));

        // Act
        Role role = RolService.toRole(roleDto);

        // Assert
        assertNotNull(role);
        assertEquals(1L, role.getId());
        assertEquals("ADMIN", role.getName());
        assertEquals("Administrator role", role.getDescription());
        assertEquals(1, role.getPermissions().size());
        assertTrue(role.getPermissions().contains(permission));
    }

    @Test
    void testToRole_PermissionNotFound() {
        // Arrange
        RoleDto roleDto = new RoleDto(1L, "ADMIN", "Administrator role", Set.of("UNKNOWN_PRIVILEGE"));

        when(permissionRepository.findByName("UNKNOWN_PRIVILEGE")).thenReturn(Optional.empty());

        // Act
        Role role = RolService.toRole(roleDto);

        // Assert
        assertNotNull(role);
        assertEquals(1L, role.getId());
        assertEquals("ADMIN", role.getName());
        assertEquals("Administrator role", role.getDescription());
        assertEquals(1, role.getPermissions().size());
        assertNull(role.getPermissions().iterator().next()); // Permission not found should return null
    }

    @Test
    void testFindById_Success() {
        // Arrange
        Role expectedRole = new Role();
        expectedRole.setId(1L);
        expectedRole.setName("ADMIN");

        when(roleRepository.findById(1L)).thenReturn(Optional.of(expectedRole));

        // Act
        Role result = RolService.findById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("ADMIN", result.getName());
    }

    @Test
    void testFindById_NotFound() {
        // Arrange
        when(roleRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Role result = RolService.findById(1L);

        // Assert
        assertNull(result);
    }
}

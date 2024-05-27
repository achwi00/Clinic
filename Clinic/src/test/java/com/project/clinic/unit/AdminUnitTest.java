package com.project.clinic.unit;

import com.project.clinic.Admin;
import com.project.repository.AdminRepository;
import com.project.service.AdminService;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Equals;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Array;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminUnitTest {
    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminService adminService;

    @Test
    public void testGetAllAdmin(){

        List<Admin> admins = Arrays.asList(
                new Admin("admin", "Aga", "Nowak", "nowaka@wp.pl"),
                new Admin("haslo", "Ola", "Kot", "okot@wp.pl")
        );
        when(adminRepository.findAll()).thenReturn(admins);
        List<Admin> result = adminService.getAllAdmin();
        assertEquals (2, result.size());
    }
    @Test
    public void testGetAdminById(){
        Admin admin = new Admin("haslo", "Jan", "Kowalski", "janko@wp.pl");
        admin.setId(3);
        when(adminRepository.findById(Long.valueOf(3))).thenReturn(Optional.of(admin));
        Optional<Admin> result = adminService.getAdminById(Long.valueOf(3));
        assertTrue(result.isPresent());
        assertEquals(admin.getName(), result.get().getName());
    }
}

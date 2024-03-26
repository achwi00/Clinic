package com.project.service;

import com.project.clinic.Admin;
import com.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmin(){
        List<Admin> admins = adminRepository.findAll();
        return admins;
    }


    public Optional<Admin> getAdminById(Long adminId){
        return  adminRepository.findById(adminId);
    }

    public void updateSessionKey(Long adminId, String newSessionKey) {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);

        optionalAdmin.ifPresent(admin -> {
            // Update the sessionKey
            admin.setSessionKey(newSessionKey);

            // Save the updated patient back to the database
            adminRepository.save(admin);
        });
    }
}
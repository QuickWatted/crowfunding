package com.example.crowdfunding.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;


    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;

    }
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setEmail(adminDetails.getEmail());
            admin.setPassword(adminDetails.getPassword());
            return adminRepository.save(admin);
        }
        return null;
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

        public boolean authenticateAdmin(String email, String password) {
            Admin admin = adminRepository.findByEmail(email);

            return admin != null && admin.getPassword().equals(password);
        }
}

package com.example.demo.runners;

import com.example.demo.entity.Role;
import com.example.demo.models.RoleEnum;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RolesInitializer implements CommandLineRunner {
    @Autowired
    private  RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!roleRepository.existsByName(RoleEnum.ROLE_USER)) {
            Role roleUser = new Role();
            roleUser.setName(RoleEnum.ROLE_USER);
            roleRepository.save(roleUser);
        }
        if (!roleRepository.existsByName(RoleEnum.ROLE_ADMIN)) {
            Role roleAdmin = new Role();
            roleAdmin.setName(RoleEnum.ROLE_ADMIN);
            roleRepository.save(roleAdmin);
        }
    }
}
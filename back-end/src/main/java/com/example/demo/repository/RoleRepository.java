package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(@Param("name") RoleEnum name);
    Boolean existsByName(@Param("name") RoleEnum name );
}

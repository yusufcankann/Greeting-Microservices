package com.auth.repository;

import com.auth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);

}


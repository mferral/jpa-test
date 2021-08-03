package com.example.jpatest.services;

import com.example.jpatest.models.Role;

public interface RoleService {
    Role findByName(String name);
}
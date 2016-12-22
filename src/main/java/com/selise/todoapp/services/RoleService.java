package com.selise.todoapp.services;

import com.selise.todoapp.models.Role;
import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findRoleById(int id);

    Role findRoleByCode(String code);

    void dumpDummyRole();
}

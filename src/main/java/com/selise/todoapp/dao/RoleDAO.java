package com.selise.todoapp.dao;

import com.selise.todoapp.models.Role;
import java.util.List;

public interface RoleDAO {

    List<Role> findAll();

    Role findRoleById(int id);

    Role findRoleByCode(String code);

    void dumpDummyRole();
}

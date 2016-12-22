package com.selise.todoapp.dao;

import com.selise.todoapp.models.User;
import java.util.List;


public interface UserDAO {
    
    List<User> findAll();

    void saveUser(User user);

    void updateUserById(int userId, User user);

    User findUserById(int userId);

    boolean isUniqueEmail(String email);

    boolean isUniqueUsername(String username);

    User findUserByUsername(String username);

    public String getLastInsertId();

    void deleteUserById(int userId);
}

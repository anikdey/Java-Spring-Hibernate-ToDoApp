package com.selise.todoapp.services;

import com.selise.todoapp.models.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

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

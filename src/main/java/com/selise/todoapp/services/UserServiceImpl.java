/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selise.todoapp.services;

import com.selise.todoapp.dao.UserDAO;
import com.selise.todoapp.models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
   @Autowired
    private UserDAO userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUserById(int userId, User user) {
        userDao.updateUserById(userId, user);
    }

    @Override
    public User findUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public boolean isUniqueEmail(String email) {
        return userDao.isUniqueEmail(email);
    }

    @Override
    public boolean isUniqueUsername(String username) {
        return userDao.isUniqueUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public String getLastInsertId() {
        return userDao.getLastInsertId();
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findUserByUsername(username);
        //Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        //authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
       // user.setAuthorities(authorities);
        return user;
    }  
}

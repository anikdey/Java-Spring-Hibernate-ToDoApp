/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.selise.todoapp.dao;

import com.selise.todoapp.models.User;
import java.util.List;
import java.util.Random;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private List<User> users;
    private User user;

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public void updateUserById(int userId, User user) {
        Query query = sessionFactory.getCurrentSession().createQuery("update " + User.class.getSimpleName()
                + " set firstName = :firstName, "
                + " where id = :id");
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("id", user.getId());
        query.executeUpdate(); // return type of this line is int.
    }

    @Override
    public User findUserById(int userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public boolean isUniqueEmail(String email) {
        boolean result = true;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        user = (User) criteria.uniqueResult();
        if (user != null) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean isUniqueUsername(String username) {
        boolean result = true;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        user = (User) criteria.uniqueResult();
        if (user != null) {
            result = false;
        }
        return result;
    }

    @Override
    public User findUserByUsername(String username) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

    @Override
    public String getLastInsertId() {
        final String sql = "SELECT max( i.id ) FROM " + User.class.getSimpleName() + " i";
        Integer lastId = (Integer) sessionFactory.getCurrentSession().createQuery(sql).uniqueResult();
        Random random = new Random();
        int randomNumber = random.nextInt(9999 - 1 + 1) + 1;
        if (lastId == null) {
            return "USER-" + randomNumber + "-" + 1;
        } else {
            Integer nextInsertId = lastId + 1;
            return "USER-" + randomNumber + "-" + nextInsertId;
        }
    }

    @Override
    public void deleteUserById(int userId) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}

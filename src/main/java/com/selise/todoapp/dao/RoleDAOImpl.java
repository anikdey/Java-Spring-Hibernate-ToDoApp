package com.selise.todoapp.dao;

import com.selise.todoapp.models.Role;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }

    @Override
    public Role findRoleById(int id) {
        return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public Role findRoleByCode(String code) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Role.class);
        //criteria.add(Restrictions.eq("code", code));
        return (Role) criteria.uniqueResult();
    }

    @Override
    public void dumpDummyRole() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        sessionFactory.getCurrentSession().persist(role);
    }
}

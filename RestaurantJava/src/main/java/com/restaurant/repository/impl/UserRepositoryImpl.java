/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;

import com.restaurant.pojo.User;
import com.restaurant.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author OS
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired
    private SessionFactory sessionFactory;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    @Transactional
    public List<User> getUsers(String username) {
        List<User> users;
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = builder.createQuery(User.class);

        Root<User> root = cr.from(User.class);

        CriteriaQuery<User> query = cr.select(root);
        if (!username.isEmpty())
            query.where(builder.equal(root.get("username"), username.trim()));

        users = session.createQuery(query).getResultList();
        
        return users;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    
    
}

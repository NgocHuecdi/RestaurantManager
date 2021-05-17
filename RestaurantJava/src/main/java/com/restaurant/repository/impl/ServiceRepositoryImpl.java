/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;


import com.restaurant.pojo.Employee;

import com.restaurant.pojo.Services;
import com.restaurant.repository.ServiceRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository

public class ServiceRepositoryImpl implements ServiceRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    @Transactional
    public List<Services> getServices(String kw) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Services> query = builder.createQuery(Services.class);
        Root root = query.from(Services.class);
        query.select(root);

        if (kw != null && !kw.isEmpty()) {

            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Services getServiceId(int serviceId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Services.class, serviceId);
    }

    @Override
    @Transactional
    public boolean addService(Services ser) {
         Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (ser.getServiceId() == 0) {
                session.save(ser);
            }
            return true;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteService(int serviceId) {
         try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Services ser = session.get(Services.class, serviceId);
            session.delete(ser);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}

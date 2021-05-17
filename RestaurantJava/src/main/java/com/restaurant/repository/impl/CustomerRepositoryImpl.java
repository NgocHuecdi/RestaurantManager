/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;

import com.restaurant.pojo.Customer;
import com.restaurant.pojo.User;

import com.restaurant.repository.CustomerRepository;
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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Customer> getCustomers(String kw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root customerRoot = query.from(Customer.class);
        Root userRoot = query.from(User.class);
        
        query = query  .where(builder.and(
                    builder.equal(userRoot.get("id"), customerRoot.get("user"))
        ));
        query.multiselect(customerRoot.get("customerId"), 
                userRoot.get("username").as(String.class),
                customerRoot.get("name").as(String.class),
                customerRoot.get("phone").as(String.class),
                customerRoot.get("address").as(String.class));
         
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Customer getCustomerById(int customerId) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Customer.class, customerId);
    }

    @Override
    @Transactional
    public boolean addCustomer(Customer cus) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (cus.getCustomerId()> 0) {
                session.update(cus);
            } else {
                session.save(cus);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}

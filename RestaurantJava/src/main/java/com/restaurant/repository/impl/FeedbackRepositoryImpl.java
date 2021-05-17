/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;

import com.restaurant.pojo.Customer;
import com.restaurant.pojo.Feedback;
import com.restaurant.repository.FeedbackRepository;
import java.util.Date;
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
 * @author OS
 */
@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object[]> getFeedbacks(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root customerRoot = query.from(Customer.class);
        Root feedbackRoot = query.from(Feedback.class);
        
        query = query.where(builder.and(
                    builder.equal(customerRoot.get("customerId"), feedbackRoot.get("customer"))
        ));
        
         query.multiselect(feedbackRoot.get("feedbackId"), 
                customerRoot.get("name").as(String.class),
                feedbackRoot.get("description").as(String.class),
                feedbackRoot.get("date").as(Date.class));
         
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean addFeedback(Feedback f) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (f.getFeedbackId() == 0) {
                session.save(f);
            }
            return true;
        } catch (HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Feedback getFbById(int i) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Feedback.class, i);
    }
}

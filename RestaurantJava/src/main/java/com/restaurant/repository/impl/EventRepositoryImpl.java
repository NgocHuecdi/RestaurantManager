/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;

import com.restaurant.pojo.Event;
import com.restaurant.pojo.Hall;
import com.restaurant.repository.EventRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class EventRepositoryImpl implements EventRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    @Transactional
    public List<Event> getEvents(String kw) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
         CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Event> query = builder.createQuery(Event.class);
        Root root = query.from(Event.class);
        query.select(root);

        if (kw != null && !kw.isEmpty()) {

            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public Event getEventById(int eventId) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Event.class, eventId);
    }

 

  
    
}

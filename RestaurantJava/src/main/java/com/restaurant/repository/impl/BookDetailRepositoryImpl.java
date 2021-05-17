/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;

import com.restaurant.pojo.Book;
import com.restaurant.pojo.BookDetail;
import com.restaurant.pojo.Customer;
import com.restaurant.pojo.Event;
import com.restaurant.pojo.Hall;
import com.restaurant.pojo.Services;
import com.restaurant.repository.BookDetailRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class BookDetailRepositoryImpl implements BookDetailRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Object[]> getBookDetail(String kw) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root customerRoot = query.from(Customer.class);
        Root serviceRoot = query.from(Services.class);
        Root eventRoot = query.from(Event.class);
        Root bookDetailRoot = query.from(BookDetail.class);
        Root hallRoot = query.from(Hall.class);

        if ( !kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(hallRoot.get("name").as(String.class), pattern);
            Predicate p2 =  builder.like(bookDetailRoot.get("dateUse").as(String.class), kw);
            Predicate p3 = builder.like(eventRoot.get("price").as(String.class), kw);
            query = query.where(builder.and(
                    builder.equal(customerRoot.get("customerId"), bookDetailRoot.get("customer")),
                    builder.equal(serviceRoot.get("serviceId"), bookDetailRoot.get("services")),
                    builder.equal(eventRoot.get("eventId"), bookDetailRoot.get("event")),
                    builder.equal(hallRoot.get("hallId"), bookDetailRoot.get("hall")),
//                    builder.like(bookDetailRoot.get("dateUse").as(String.class), kw),
                    builder.or(p1,p2,p3)
            ));

            query.multiselect(bookDetailRoot.get("id"),
                    customerRoot.get("name").as(String.class),
                    customerRoot.get("phone").as(String.class),
                    customerRoot.get("address").as(String.class),
                    serviceRoot.get("name").as(String.class),
                    eventRoot.get("name").as(String.class),
                    hallRoot.get("name").as(String.class),
                    bookDetailRoot.get("dateUse").as(String.class),
                    bookDetailRoot.get("numberGuest").as(Double.class),
                    bookDetailRoot.get("description").as(String.class),
                    builder.count(bookDetailRoot.get("id"))
            );
            query.groupBy(bookDetailRoot.get("id"),
                    customerRoot.get("name").as(String.class),
                    customerRoot.get("phone").as(String.class),
                    customerRoot.get("address").as(String.class),
                    serviceRoot.get("name").as(String.class),
                    eventRoot.get("name").as(String.class),
                    hallRoot.get("name").as(String.class),
                    bookDetailRoot.get("dateUse").as(String.class),
                    bookDetailRoot.get("numberGuest").as(Double.class),
                    bookDetailRoot.get("description").as(String.class)
            );

        } else {
            query = query.where(builder.and(
                    builder.equal(customerRoot.get("customerId"), bookDetailRoot.get("customer")),
                    builder.equal(serviceRoot.get("serviceId"), bookDetailRoot.get("services")),
                    builder.equal(eventRoot.get("eventId"), bookDetailRoot.get("event")),
                    builder.equal(hallRoot.get("hallId"), bookDetailRoot.get("hall"))
            //  builder.like(bookDetailRoot.get("dateUse").as(String.class), kw)
            ));

            query.multiselect(bookDetailRoot.get("id"),
                    customerRoot.get("name").as(String.class),
                    customerRoot.get("phone").as(String.class),
                    customerRoot.get("address").as(String.class),
                    serviceRoot.get("name").as(String.class),
                    eventRoot.get("name").as(String.class),
                    hallRoot.get("name").as(String.class),
                    bookDetailRoot.get("dateUse").as(String.class),
                    bookDetailRoot.get("numberGuest").as(Double.class),
                    bookDetailRoot.get("description").as(String.class),
                    builder.count(bookDetailRoot.get("id"))
            );
            query.groupBy(bookDetailRoot.get("id"),
                    customerRoot.get("name").as(String.class),
                    customerRoot.get("phone").as(String.class),
                    customerRoot.get("address").as(String.class),
                    serviceRoot.get("name").as(String.class),
                    eventRoot.get("name").as(String.class),
                    hallRoot.get("name").as(String.class),
                    bookDetailRoot.get("dateUse").as(String.class),
                    bookDetailRoot.get("numberGuest").as(Double.class),
                    bookDetailRoot.get("description").as(String.class)
            );

        }

        Query q = session.createQuery(query);
        return q.getResultList();

    }

    @Override
    @Transactional
    public BookDetail getBookDetailById(int bookDetailId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(BookDetail.class, bookDetailId);
    }

    @Override
    @Transactional
    public boolean addBook(BookDetail bookDetail) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (bookDetail.getId() == 0) {

                session.save(bookDetail);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteBookDetail(int bookDetailId) {
         try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            BookDetail bookDetail = session.get(BookDetail.class, bookDetailId);
            session.delete(bookDetail);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public boolean deleteBookParty(int bookDetailId) {
         try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            BookDetail bookDetail = session.get(BookDetail.class, bookDetailId);
            session.delete(bookDetail);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    
}

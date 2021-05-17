/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository.impl;

import com.restaurant.pojo.Employee;
import com.restaurant.pojo.User;
import com.restaurant.repository.EmployeeRepository;
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
 * @author HP
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Employee> getEmployeies(String kw) {

        Session s = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root employeeRoot = query.from(Employee.class);
        Root userRoot = query.from(User.class);

        if (kw != null && !kw.isEmpty()) {
            String pattern = String.format("%%%s%%", kw);
            Predicate p1 = builder.like(employeeRoot.get("name").as(String.class), pattern);
             Predicate p2 = builder.like(employeeRoot.get("address").as(String.class), pattern);
            query = query.where(builder.and(
                    builder.equal(userRoot.get("id"), employeeRoot.get("user")),
                    builder.or(p1,p2)
            ));
            query.multiselect(employeeRoot.get("empId"),
                    userRoot.get("username").as(String.class),
                    employeeRoot.get("name").as(String.class),
                    employeeRoot.get("mail").as(String.class),
                    employeeRoot.get("address").as(String.class),
                    employeeRoot.get("birth").as(String.class));
             query.groupBy(employeeRoot.get("empId"),
                    userRoot.get("username").as(String.class),
                    employeeRoot.get("name").as(String.class),
                    employeeRoot.get("mail").as(String.class),
                    employeeRoot.get("address").as(String.class),
                    employeeRoot.get("birth").as(String.class));
        } else {
            query = query.where(builder.and(
                    builder.equal(userRoot.get("id"), employeeRoot.get("user"))));
            query.multiselect(employeeRoot.get("empId"),
                    userRoot.get("username").as(String.class),
                    employeeRoot.get("name").as(String.class),
                    employeeRoot.get("mail").as(String.class),
                    employeeRoot.get("address").as(String.class),
                    employeeRoot.get("birth").as(String.class));
              query.groupBy(employeeRoot.get("empId"),
                    userRoot.get("username").as(String.class),
                    employeeRoot.get("name").as(String.class),
                    employeeRoot.get("mail").as(String.class),
                    employeeRoot.get("address").as(String.class),
                    employeeRoot.get("birth").as(String.class));
        }
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    @Transactional
    public boolean addOrUpdateEmployee(Employee emp) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            if (emp.getEmpId() > 0) {
                session.update(emp);
            } else {
                session.save(emp);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteEmployee(int employeeId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Employee emp = session.get(Employee.class, employeeId);
            session.delete(emp);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public Employee getEmpById(int empId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Employee.class, empId);
    }

}

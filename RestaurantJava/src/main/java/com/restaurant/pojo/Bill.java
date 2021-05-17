/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "bills")
public class Bill implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
            
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name = "empId")
    private Employee employee;
    
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Services services;
    
    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
    
    @OneToOne
    @JoinColumn(name = "bookDetailId")
    private BookDetail bookDetail;
    
    @ManyToOne
    @JoinColumn(name = "hallId")
    private Hall hall;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePay;
    

    /**
     * @return the billId
     */
    public int getBillId() {
        return billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(int billId) {
        this.billId = billId;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the services
     */
    public Services getServices() {
        return services;
    }

    /**
     * @param services the services to set
     */
    public void setServices(Services services) {
        this.services = services;
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * @return the datePay
     */
    public Date getDatePay() {
        return datePay;
    }

    /**
     * @param datePay the datePay to set
     */
    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }
       /**
     * @return the bookDetail
     */
    public BookDetail getBookDetail() {
        return bookDetail;
    }

    /**
     * @param bookDetail the bookDetail to set
     */
    public void setBookDetail(BookDetail bookDetail) {
        this.bookDetail = bookDetail;
    }
        /**
     * @return the hall
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * @param hall the hall to set
     */
    public void setHall(Hall hall) {
        this.hall = hall;
    }
    
}

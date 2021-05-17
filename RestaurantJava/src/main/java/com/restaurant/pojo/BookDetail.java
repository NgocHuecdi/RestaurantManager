/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "book_detail")
public class BookDetail implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
        
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Services services;
    
    @ManyToOne
    @JoinColumn(name = "eventId")
    private Event event;
    
    @ManyToOne
    @JoinColumn(name = "hallId")
    private Hall hall;
    
    
//    @OneToOne(mappedBy = "bills")
//    private Bill bill;
    
 
//     @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(javax.persistence.TemporalType.DATE)
    private String dateUse;
    
    private Double numberGuest;
    private String description;
    
       /**
     * @return the bookDetailId
     */
    public int getId() {
        return id;
    }

    /**
     * @param bookDetailId the bookDetailId to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the dateUse
     */
    public String getDateUse() {
        return dateUse;
    }

    /**
     * @param dateUse the dateUse to set
     */
    public void setDateUse(String dateUse) {
        this.dateUse = dateUse;
    }
    /**
     * @return the numberGuest
     */
    public Double getNumberGuest() {
        return numberGuest;
    }

    /**
     * @param numberGuest the numberGuest to set
     */
    public void setNumberGuest(Double numberGuest) {
        this.numberGuest = numberGuest;
    }
    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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

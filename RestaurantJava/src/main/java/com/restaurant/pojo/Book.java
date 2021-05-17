/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Book {

    private int bookDetailId;
    private String customerName;
    private String phone;
    private String address;
    private String serviceName;
    private String eventName;
    private Date dateUse;
    private Double numberGuest;
    private String description;
    private Integer quantity;
    
    
//    public Book(int bookDetailId,String customerName,String phone,String address, String serviceNamee, String eventName, 
//            Date dateUse, double numberGuest, String discription){
//        this.bookDetailId = bookDetailId;
//        this.customerName = customerName;
//        this.phone = phone;
//        this.address = address;
//        this.eventName = eventName;
//        this.numberGuest = numberGuest;
//        this.dateUse = dateUse;
//        this.numberGuest = numberGuest;
//        this.discription = discription;
//    }

    /**
     * @return the bookId
     */
    public int getBookDetailId() {
        return bookDetailId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookDetailId(int bookDetailId) {
        this.bookDetailId = bookDetailId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the dateUse
     */
    public Date getDateUse() {
        return dateUse;
    }

    /**
     * @param dateUse the dateUse to set
     */
    public void setDateUse(Date dateUse) {
        this.dateUse = dateUse;
    }

    /**
     * @return the numberGuest
     */
    public double getNumberGuest() {
        return numberGuest;
    }

    /**
     * @param numberGuest the numberGuest to set
     */
    public void setNumberGuest(double numberGuest) {
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
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

  
}

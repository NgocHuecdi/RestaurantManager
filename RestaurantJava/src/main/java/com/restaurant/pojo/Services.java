/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "services")
public class Services implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int serviceId;
    private String name;
    private BigDecimal unit_price;
    @OneToMany(mappedBy = "services", fetch = FetchType.EAGER)
    private List<BookDetail> bookDetail;

    @Override
    public String toString() {
        return String.valueOf(serviceId);
    }
    /**
     * @return the serviceId
     */
    public int getServiceId() {
        return serviceId;
    }

    /**
     * @param serviceId the serviceId to set
     */
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the unit_price
     */
    public BigDecimal getUnit_price() {
        return unit_price;
    }

    /**
     * @param unit_price the unit_price to set
     */
    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }
        /**
     * @return the bookDetail
     */
    public List<BookDetail> getBookDetail() {
        return bookDetail;
    }

    /**
     * @param bookDetail the bookDetail to set
     */
    public void setBookDetail(List<BookDetail> bookDetail) {
        this.bookDetail = bookDetail;
    }

}

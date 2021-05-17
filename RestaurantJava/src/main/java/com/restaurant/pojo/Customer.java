/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


/**
 *
 * @author HP
 */
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int customerId;
    @NotEmpty(message = "{cus.name.error.notNullMsg}")
    private String name;
    @NotEmpty(message = "{cus.phone.error.notNullMsg}")
    private String phone;
    @NotEmpty(message = "{cus.address.error.notNullMsg}")
    private String address;
//    @OneToMany(mappedBy = "customers", fetch = FetchType.EAGER)
//    private List<BookDetail> bookDetail;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<BookDetail> bookDetail;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @Override
    public String toString() {
        return String.valueOf(customerId);
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
     * @return the customerId
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
     * @return the feedback
     */
        /**
     * @return the bookDetail
     */
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

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
}

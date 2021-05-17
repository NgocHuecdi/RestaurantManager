/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author OS
 */
@Entity
@Table(name = "user")
public class User implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    
   @Size(min = 1, max = 45, message = "{user.username.error.sizeMsg}")
    private String username;
    @NotEmpty(message = "{user.password.error.sizeMsg}")
    private String password;
    @Column(name = "role_user")
    private String role_user;
    @Transient
    private String confirmPassword;
    
    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role_user
     */
    public String getRole_user() {
        return role_user;
    }

    /**
     * @param role_user the role_user to set
     */
    public void setRole_user(String role_user) {
        this.role_user = role_user;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

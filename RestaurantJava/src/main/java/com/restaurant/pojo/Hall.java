/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "halls")
public class Hall implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hallId;
    private String name;
    private int seat;
    
    
        
    @Override
    public String toString() {
        return String.valueOf(hallId);
    }

    /**
     * @return the hallId
     */
    public int getHallId() {
        return hallId;
    }

    /**
     * @param hallId the hallId to set
     */
    public void setHallId(int hallId) {
        this.hallId = hallId;
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
     * @return the seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(int seat) {
        this.seat = seat;
    }

}

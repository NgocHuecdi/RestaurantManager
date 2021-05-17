/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.pojo.Hall;
import java.util.List;

/**
 *
 * @author HP
 */
public interface HallService {
    List<Hall> getHalls(String kw);
    Hall getHallById(int hallId);
}

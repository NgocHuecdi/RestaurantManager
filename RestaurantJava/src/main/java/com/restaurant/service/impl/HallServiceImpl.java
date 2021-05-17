/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Hall;
import com.restaurant.repository.HallRepository;
import com.restaurant.service.HallService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class HallServiceImpl implements HallService{
    @Autowired
    private HallRepository hallRepository;

    @Override
    public List<Hall> getHalls(String kw) {
        return this.hallRepository.getHalls(kw);
    }

    @Override
    public Hall getHallById(int hallId) {
        return this.hallRepository.getHallById(hallId);
    }
    
}

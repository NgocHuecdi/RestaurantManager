/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Services;
import com.restaurant.repository.ServiceRepository;
import com.restaurant.service.ServicesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author HP
 */

@Service
public class ServicesImpl implements ServicesService{

    @Autowired
    private ServiceRepository serviceRepository;
    @Override
    public List<Services> getServices(String kw) {
        return this.serviceRepository.getServices(kw);
    }

    @Override
    public Services getServiceId(int serviceId) {

         return this.serviceRepository.getServiceId(serviceId);

    }

    @Override
    public boolean addService(Services ser) {

      return this.serviceRepository.addService(ser);   

    }

    @Override
    public boolean deleteService(int serviceId) {
        return this.serviceRepository.deleteService(serviceId);
    }
    
}

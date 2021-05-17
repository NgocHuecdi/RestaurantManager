/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.service.EmployeeService;
import com.restaurant.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiServiceController {
    
    @Autowired
    private ServicesService servicesService;
    
    
    @DeleteMapping("/services/{serviceId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteService(@PathVariable(name = "serviceId") int serviceId){
        this.servicesService.deleteService(serviceId);
  
    }
    
}

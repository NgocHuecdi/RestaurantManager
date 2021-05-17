/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.pojo.Services;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ServicesService {
    List<Services> getServices(String kw);
    Services getServiceId(int serviceId);
    boolean addService(Services ser);
    boolean deleteService(int serviceId);
}

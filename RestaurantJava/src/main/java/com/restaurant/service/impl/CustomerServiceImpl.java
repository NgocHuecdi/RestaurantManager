/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Customer;
import com.restaurant.repository.CustomerRepository;
import com.restaurant.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers(String kw) {
        return this.customerRepository.getCustomers(kw);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return this.customerRepository.getCustomerById(customerId);
    }

    @Override
    public boolean addCustomer(Customer cstmr) {
        return this.customerRepository.addCustomer(cstmr);
    }
    
}

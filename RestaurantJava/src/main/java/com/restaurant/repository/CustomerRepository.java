/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository;

import com.restaurant.pojo.Customer;
import java.util.List;

/**
 *
 * @author HP
 */
public interface CustomerRepository {
    List<Customer> getCustomers(String kw);
    Customer getCustomerById(int customerId);
    boolean addCustomer(Customer cus);
}

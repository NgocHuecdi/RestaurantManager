/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Employee;
import com.restaurant.repository.EmployeeRepository;
import com.restaurant.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author HP
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeies(String kw) {
        return this.employeeRepository.getEmployeies(kw);
    }

    @Override
    public boolean addOrUpdateEmployee(Employee emp) {
//        Session session = this.sessionFacto
       return this.employeeRepository.addOrUpdateEmployee(emp);
    }

    @Override
    public boolean deleteEmployee(int EmployeeId) {
        return this.employeeRepository.deleteEmployee(EmployeeId);
    }

    @Override
    public Employee getEmpById(int empId) {
        return this.employeeRepository.getEmpById(empId);
    }   
}

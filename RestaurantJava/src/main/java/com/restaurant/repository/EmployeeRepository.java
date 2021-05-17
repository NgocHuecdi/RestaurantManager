/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository;

import com.restaurant.pojo.Employee;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EmployeeRepository {
    List<Employee> getEmployeies(String kw);
    Employee getEmpById(int empId);
    boolean addOrUpdateEmployee(Employee emp);
    boolean deleteEmployee(int EmployeeId);
}

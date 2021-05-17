/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaunrant.formatter;

import com.restaurant.pojo.Employee;
import java.text.ParseException;
import java.util.Locale;
import org.hibernate.boot.archive.scan.spi.ClassDescriptor;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class EmployeeFormatter implements Formatter<Employee>{

    @Override
    public String print(Employee t, Locale locale) {
        return String.valueOf(t.getEmpId());
    }

    @Override
    public Employee parse(String string, Locale locale) throws ParseException {
        Employee emp = new Employee();
        emp.setEmpId(Integer.parseInt(string));
        return emp;
    }
    
}

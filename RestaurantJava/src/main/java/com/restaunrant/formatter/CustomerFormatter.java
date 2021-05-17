/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaunrant.formatter;
import com.restaurant.pojo.Customer;
import java.text.ParseException;
import java.util.Locale;
import org.hibernate.boot.archive.scan.spi.ClassDescriptor;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class CustomerFormatter implements Formatter<Customer>{

    @Override
    public String print(Customer t, Locale locale) {
         return String.valueOf(t.getCustomerId());
    }

    @Override
    public Customer parse(String string, Locale locale) throws ParseException {
         Customer c = new Customer();
        c.setCustomerId(Integer.parseInt(string));
        
        return c;
    }
    
}

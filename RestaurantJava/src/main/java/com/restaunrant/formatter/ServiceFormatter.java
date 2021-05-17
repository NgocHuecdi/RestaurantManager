/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaunrant.formatter;

import com.restaurant.pojo.Services;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */

public class ServiceFormatter implements Formatter<Services>{

    @Override
    public String print(Services t, Locale locale) {
        return String.valueOf(t.getServiceId());
    }

    @Override
    public Services parse(String string, Locale locale) throws ParseException {
        Services s = new Services();
        s.setServiceId(Integer.parseInt(string));
        
        return s;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaunrant.formatter;

import com.restaurant.pojo.Hall;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class HallFormatter implements Formatter<Hall>{
    @Override
    public String print(Hall h, Locale locale) {
        return String.valueOf(h.getHallId());
    }

    @Override
    public Hall parse(String string, Locale locale) throws ParseException {
        Hall e = new Hall();
        e.setHallId(Integer.parseInt(string));
        
        return e;
    }

    
}

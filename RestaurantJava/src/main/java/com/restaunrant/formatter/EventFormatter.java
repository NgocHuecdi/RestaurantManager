/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaunrant.formatter;

import com.restaurant.pojo.Event;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author HP
 */
public class EventFormatter implements Formatter<Event>{

    @Override
    public String print(Event t, Locale locale) {
        return String.valueOf(t.getEventId());
    }

    @Override
    public Event parse(String string, Locale locale) throws ParseException {
        Event e = new Event();
        e.setEventId(Integer.parseInt(string));
        
        return e;
    }
    
}

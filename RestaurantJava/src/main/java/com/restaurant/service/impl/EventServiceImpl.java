/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Event;
import com.restaurant.repository.EventRepository;
import com.restaurant.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;
   @Override
    public List<Event> getEvents(String kw) {
        return this.eventRepository.getEvents(kw);
    }

    @Override
    public Event getEventById(int eventId) {
        return this.eventRepository.getEventById(eventId);
    }

   
    
}

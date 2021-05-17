/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository;

import com.restaurant.pojo.Event;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EventRepository {
    List<Event> getEvents(String kw);
    Event getEventById(int eventId);
}

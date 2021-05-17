/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.pojo.Book;
import com.restaurant.pojo.BookDetail;
import com.restaurant.pojo.Customer;
import com.restaurant.pojo.Event;
import com.restaurant.pojo.Services;
import com.restaurant.repository.BookDetailRepository;
import com.restaurant.repository.EventRepository;
import com.restaurant.repository.ServiceRepository;
import com.restaurant.service.BookDetailService;
import com.restaurant.service.CustomerService;
import com.restaurant.service.EventService;
import com.restaurant.service.ServicesService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiBookPartyController {
    @Autowired
    private BookDetailService bookDetailService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServicesService servicesService; 
    @Autowired
    private EventService eventService;
    
    @GetMapping("/viewBook")
    public ResponseEntity<List<Object[]>> getBookDetail() {
        return new ResponseEntity<>(this.bookDetailService.getBookDetail(null), HttpStatus.OK);
    }
    
//    @GetMapping("/viewBook/{bookDetailId}")
//    @ResponseStatus(HttpStatus.OK)
//  public void addBookParty(@PathVariable(name = "bookDetailId") int bookDetailId,int customerId, 
//          int serviceId, int eventId,
//            HttpSession session) {
//        
//        Map<Integer, Book> book = (Map<Integer, Book>) session.getAttribute("viewBook");
//        if (book == null)
//            book = new HashMap<>();
//        
//        if (book.containsKey(bookDetailId) == true) {
//            Book b = book.get(bookDetailId);
//            b.setQuantity(b.getQuantity() + 1);
//        }
//        if(book.containsKey(bookDetailId) == false) {
//         
//            BookDetail bookDetail = this.bookDetailService.getBookDetailById(bookDetailId);
//            Customer customer = this.customerService.getCustomerById(customerId);
//            Services services = this.servicesService.getServiceId(serviceId);
//            Event event = this.eventService.getEventById(eventId);
//            
//            Book b = new Book();
//            b.setBookDetailId(bookDetail.getId());
//            b.setCustomerName(customer.getName());
//            b.setAddress(customer.getAddress());
//            b.setPhone(customer.getPhone());
//            b.setServiceName(services.getName());
//            b.setEventName(event.getName());
//            b.setDateUse(bookDetail.getDateUse());
//            b.setDescription(bookDetail.getDescription());
//            b.setQuantity(1);
//            book.put(bookDetailId, b);
//        }
        
//        session.setAttribute("viewBook", book);
//    }
  
    @DeleteMapping("/viewBook/{bookDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBookDetail(@PathVariable(name = "bookDetailId") int bookDetailId){
        this.bookDetailService.deleteBookDetail(bookDetailId);
  
    }
    
    @DeleteMapping("/bookParty/{bookDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBookParty(@PathVariable(name = "bookDetailId") int bookDetailId){
        this.bookDetailService.deleteBookDetail(bookDetailId);
  
    }
}

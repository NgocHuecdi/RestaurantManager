/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;



import com.restaurant.service.BookDetailService;
import com.restaurant.service.CustomerService;
import com.restaurant.service.EmployeeService;
import com.restaurant.service.EventService;
import com.restaurant.service.HallService;
import com.restaurant.service.ServicesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private EventService eventService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private HallService hallService;
    @Autowired
    private BookDetailService bookDetailService;
    @Autowired
    private EmployeeService employeeService;
    
    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
         model.addAttribute("services", this.servicesService.getServices(""));
        model.addAttribute("event", this.eventService.getEvents(""));
        model.addAttribute("customer", this.customerService.getCustomers(""));
         model.addAttribute("hall", this.hallService.getHalls(""));
         model.addAttribute("employees", this.employeeService.getEmployeies(""));
       
    }
    
    @RequestMapping("/") //mapping vao trang chu
    public String index(Model model){
        int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
             model.addAttribute("totalBook",totalBook);
//        model.addAttribute("services", this.servicesService.getServices(""));
//        model.addAttribute("events", this.eventService.getEvents());
        return "index";
    }
    
}

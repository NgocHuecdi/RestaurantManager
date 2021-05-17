/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;
import com.restaurant.pojo.Customer;
import com.restaurant.service.CustomerService;
import com.restaurant.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author OS
 */
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    
    @RequestMapping("/customerInfo")
    public String addView(Model model,
                    @RequestParam(name = "customerId", required=false, defaultValue = "0") int customerId) {
        if (customerId > 0) 
            model.addAttribute("customerInfo", this.customerService.getCustomerById(customerId));
           
        
        else 
            model.addAttribute("user", this.userService.getUsers(""));
            model.addAttribute("customerInfo", new Customer());
        
        return "customerInfo";
    }
    
    @PostMapping("/customerInfo/submit")
   public String customerInfo(Model model,
       @ModelAttribute(value = "customerInfo") @Valid Customer cus,
        BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("user", this.userService.getUsers(""));
            return "customerInfo";
        }
        
        if (!this.customerService.addCustomer(cus)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            model.addAttribute("user", this.userService.getUsers(""));
            return "customerInfo";
        }
        
        return "redirect:/";
    }
}

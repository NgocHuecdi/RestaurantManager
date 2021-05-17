/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.pojo.Employee;
import com.restaurant.pojo.User;
import com.restaurant.service.EmployeeService;
import com.restaurant.service.UserService;
import com.restaurant.service.BookDetailService;
import java.util.List;

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
 * @author HP
 */
@Controller
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private BookDetailService bookDetailService;
    
    @RequestMapping("/employee") //mapping vao trang chu
    public String employee(Model model,@RequestParam(name="kw", required = false) String kw){

        if(kw != null){
            model.addAttribute("employees", this.employeeService.getEmployeies(kw));
        }
        else {
            model.addAttribute("employees", this.employeeService.getEmployeies(""));
        }
          int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
             model.addAttribute("totalBook",totalBook);
        return "employee";
    }
     
   @RequestMapping("/addemp")
    public String addView(Model model,
                    @RequestParam(name = "empId", required=false, defaultValue = "0") int empId) {
        if (empId > 0) 
            model.addAttribute("addemp", this.employeeService.getEmpById(empId));
 
        else 
            model.addAttribute("user", this.userService.getUsers(""));
            model.addAttribute("addemp", new Employee());
        
        return "addemp";
    }
    @RequestMapping("/updateEmp")
    public String updateEmploy(Model model,  
            @RequestParam(name = "empId", required=false, defaultValue = "0") int empId){
         if (empId > 0) {
            model.addAttribute("updateEmp", this.employeeService.getEmpById(empId));
            model.addAttribute("user", this.userService.getUsers(""));
         }
         int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
             model.addAttribute("totalBook",totalBook);
        return "updateEmp";
    }
    
    @PostMapping("/addemp")
   public String addEmploy(Model model,
       @ModelAttribute(value = "addemp") @Valid Employee emp,
        BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("user", this.userService.getUsers(""));
            return "addemp";
        }
        
        if (!this.employeeService.addOrUpdateEmployee(emp)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            model.addAttribute("user", this.userService.getUsers(""));
            return "addemp";
        }
        
        return "redirect:/employee";
    }
   
   @PostMapping("/updateEmp/add")
   public String updateEmploy(Model model,
       @ModelAttribute(value = "updateEmp") @Valid Employee emp,
        BindingResult result) {
        if (result.hasErrors()) {
            return "updateEmp";
        }
        
        if (!this.employeeService.addOrUpdateEmployee(emp)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "updateEmp";
        }
        
        return "redirect:/employee";
    }
       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.pojo.Services;
import com.restaurant.service.BookDetailService;
import com.restaurant.service.ServicesService;
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

public class ServicesController {

    @Autowired
    private ServicesService servicesService;
       @Autowired
    private BookDetailService bookDetailService;

    @RequestMapping("/services") //mapping vao trang chu
    public String services(Model model, @RequestParam(name = "name", required = false) String name) {

        model.addAttribute("services", this.servicesService.getServices(""));
        int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
        model.addAttribute("totalBook",totalBook);
        return "services";
    }

    @RequestMapping("/addService")
    public String addView(Model model,
            @RequestParam(name = "serviceId", required = false, defaultValue = "0") int serviceId) {
        if (serviceId == 0) {
            model.addAttribute("addService", new Services());
        }
          //Bill
          int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
        model.addAttribute("totalBook",totalBook);

        return "addService";
    }

    @PostMapping("/addService/add")

    public String addSer(Model model,
            @ModelAttribute(value = "addService") @Valid Services ser,
            BindingResult result) {
   

        if (!this.servicesService.addService(ser)) {
            model.addAttribute("erroMsg", "Something Wrong!!!");
            return "addService";
        }

        return "redirect:/services";
    }
}

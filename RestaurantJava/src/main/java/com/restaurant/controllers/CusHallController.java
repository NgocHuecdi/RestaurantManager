/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
public class CusHallController {
    @Autowired
    private HallService hallService;
     @RequestMapping("/hall") //mapping vao trang chu
    public String cusEvent(Model model, @RequestParam(name = "name", required = false) String name){
        model.addAttribute("hall", this.hallService.getHalls(""));
        return "hall";
    }
}

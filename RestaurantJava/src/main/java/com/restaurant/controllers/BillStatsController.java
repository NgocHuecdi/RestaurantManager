/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.pojo.Bill;
import com.restaurant.pojo.BookDetail;
import com.restaurant.service.BillStatsService;
import com.restaurant.service.BookDetailService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HP
 */
@Controller
public class BillStatsController {
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    
    @Autowired
    private BillStatsService billStatsService;
    
    @Autowired
    private BookDetailService bookDetailService;
       
       
    @RequestMapping("/billParty")
    public String billParty(Model model, @RequestParam(name = "bookDetailId", required = false, defaultValue = "0") int bookDetailId) {
        if (bookDetailId > 0) {
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
            model.addAttribute("billParty", new Bill());
            model.addAttribute("bookDetails", bookDetails);
            model.addAttribute("bookDetail", this.bookDetailService.getBookDetailById(bookDetailId));
        }
        int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
             model.addAttribute("totalBook",totalBook);
        return "billParty";
    }
     @PostMapping("/billParty/add")
    public String addBookParty(Model model,
            @ModelAttribute(value = "billParty") @Valid Bill bill,
            BindingResult result) {

        if (result.hasErrors()) {
            return "billParty";
        }
        if (!this.billStatsService.addBill(bill)) {
            model.addAttribute("erroMsg", "Something loi!!!");
            return "billParty";
        }

        return "redirect:/viewBook";
    }
    @GetMapping("/statsRe")
    public String statsRe(Model model,  @RequestParam(name = "fromDate", required = false) String fromDate,
             @RequestParam(name = "toDate", required = false) String toDate) {
        
        Date fr = null, to = null;
        
        try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        List<Object[]> dataBills = this.billStatsService.getBillStats(fr, to);
        List<BigDecimal> total = new ArrayList<>();
        for (Object[] d: dataBills)
            total.add((BigDecimal) d[7]);
        
            //Bill
          int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
        model.addAttribute("totalBook",totalBook); 
                
        model.addAttribute("dataBills", dataBills);
        model.addAttribute("total", total);
       return "statsRe";
    
   }
     @GetMapping("/statsDen")
    public String statsDe(Model model, @RequestParam(name = "fromDate", required = false) String fromDate,
             @RequestParam(name = "toDate", required = false) String toDate){
         Date fr = null, to = null;
        
           try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        List<Object[]> des = this.billStatsService.getBillStats(fr, to);
        List<Long> total = new ArrayList<>();
        int totalCount = 0;
        
        
        for (Object[] d: des){
            totalCount++; 
        }
        
         for (Object[] d: des)
            total.add((Long) d[8]);
         
         //Bill
          int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
              for (Object[] bd : bookDetails) {
                totalBook++;
            }
             
        model.addAttribute("totalBook",totalBook);
                
        model.addAttribute("des", des);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("total",total);
        return "statsDen";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.pojo.BookDetail;
import com.restaurant.service.BookDetailService;
import com.restaurant.service.EventService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
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
public class BookPartyController {

    @Autowired
    private SimpleDateFormat simpleDateFormat;
    @Autowired
    private BookDetailService bookDetailService;
    @Autowired
    private EventService eventService;

    @GetMapping("/viewBook") //mapping vao trang chu
    public String viewBook(Model model, HttpSession session,
            @RequestParam(name = "kw", required = false) String kw) {

        if (kw != null) {
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail(kw);

            int totalBook = 0;

            for (Object[] bd : bookDetails) {
                totalBook++;
            }
            model.addAttribute("bookDetails", bookDetails);
            model.addAttribute("totalBook", totalBook);
        } else {
            int totalBook = 0;
            List<Object[]> bookDetails = this.bookDetailService.getBookDetail("");
            for (Object[] bd : bookDetails) {
                totalBook++;
            }
            model.addAttribute("bookDetails", bookDetails);
            model.addAttribute("totalBook", totalBook);
        }

        return "viewBook";
    }

    @RequestMapping("/bookParty")
    public String addView(Model model,
            @RequestParam(name = "bookDetailId", required = false, defaultValue = "0") int bookDetailId) {

        if (bookDetailId == 0) {
            model.addAttribute("bookParty", new BookDetail());
        }

        return "bookParty";
    }

    @PostMapping("/bookParty/add")
    public String addBookParty(Model model,
            @ModelAttribute(value = "bookParty") @Valid BookDetail bookdetail,
            BindingResult result) {

        if (result.hasErrors()) {
            return "bookParty";
        }
        if (!this.bookDetailService.addBook(bookdetail)) {
            model.addAttribute("erroMsg", "Something looi!!!");
            return "bookParty";
        }

        return "redirect:/";
    }
}

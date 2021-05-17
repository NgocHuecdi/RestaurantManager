/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.controllers;

import com.restaurant.service.BillStatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */
@RestController
@RequestMapping("/api")
public class ApiBillController {
    @Autowired
    private BillStatsService billStatsService;
    
    
    @GetMapping("/statsRe")
    public ResponseEntity<List<Object[]>> getBillStats() {
        return new ResponseEntity<>(this.billStatsService.getBillStats(null, null), HttpStatus.OK);
    }
}

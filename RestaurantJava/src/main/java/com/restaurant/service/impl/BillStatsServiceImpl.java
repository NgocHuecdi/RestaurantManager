/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Bill;
import com.restaurant.pojo.Book;
import com.restaurant.repository.BillStatsRepository;
import com.restaurant.service.BillStatsService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class BillStatsServiceImpl implements BillStatsService {
    
    @Autowired
    private BillStatsRepository billStatsRepository;

    @Override
    public List<Object[]> getBillStats(Date fromDate, Date toDate) {
           return this.billStatsRepository.getBillStats(fromDate, toDate);
    }

    @Override
    public Bill getBillById(int billId) {
        return this.billStatsRepository.getBillById(billId);
    }

    @Override
    public boolean addBill(Bill bill) {
        return this.billStatsRepository.addBill(bill);
    }


}

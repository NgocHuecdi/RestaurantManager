/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Book;
import com.restaurant.pojo.BookDetail;
import com.restaurant.repository.BookDetailRepository;
import com.restaurant.service.BookDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class BookDetailServiceImpl implements BookDetailService{
    @Autowired
    private BookDetailRepository bookDetailRepository;

    @Override
    public List<Object[]> getBookDetail(String kw) {
        return this.bookDetailRepository.getBookDetail(kw);
    }
    
    @Override
    public BookDetail getBookDetailById(int bookDetailId) {
         return this.bookDetailRepository.getBookDetailById(bookDetailId);
    }
   

    @Override
    public boolean addBook(BookDetail bookDetail) {
        return this.bookDetailRepository.addBook(bookDetail);
    }

//    @Override
//    public List<Object[]> getSearch(String key) {
//        return  this.bookDetailRepository.getSearch(key);
//    }

    @Override
    public boolean deleteBookDetail(int bookdetailId) {
        return this.bookDetailRepository.deleteBookDetail(bookdetailId);
    }

    @Override
    public boolean deleteBookParty(int bookdetailId) {
        return this.bookDetailRepository.deleteBookDetail(bookdetailId);
    }

    
}

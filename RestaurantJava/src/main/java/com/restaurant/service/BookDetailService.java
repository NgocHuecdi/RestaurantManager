/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service;

import com.restaurant.pojo.Book;
import com.restaurant.pojo.BookDetail;
import java.util.List;

/**
 *
 * @author HP
 */
public interface BookDetailService {
    List<Object[]> getBookDetail(String kw);
    BookDetail getBookDetailById(int bookDetailId);
    boolean addBook(BookDetail bookDetail);
    boolean deleteBookDetail(int bookDetailId);
     boolean deleteBookParty(int bookDetailId);
//    List<Object[]> getSearch(String key);
}

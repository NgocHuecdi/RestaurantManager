            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.utils;

import com.restaurant.pojo.Book;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author HP
 */
public class Utils {

    public static Map<String, BigDecimal> bookStats(Map<Integer, Book> book) {
        int totalQuantity = 0;
        if (book != null) {
            for (Book b: book.values()) {
                totalQuantity += b.getQuantity();
            }
        }
        
        Map<String, BigDecimal> re = new HashMap<>();
        re.put("totalQuantity", new BigDecimal(totalQuantity));
//        re.put("totalService", new BigDecimal());
        return re;

    }
}

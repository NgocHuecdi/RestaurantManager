/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.repository;

import com.restaurant.pojo.User;
import java.util.List;

/**
 *
 * @author OS
 */
public interface UserRepository {
    void addUser(User user);
    List<User> getUsers(String username);
}

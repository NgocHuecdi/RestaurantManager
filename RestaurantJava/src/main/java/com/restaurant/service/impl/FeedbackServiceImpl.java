/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.service.impl;

import com.restaurant.pojo.Feedback;
import com.restaurant.repository.FeedbackRepository;
import com.restaurant.service.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author OS
 */
@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Override
    public List<Object[]> getFeedbacks(String kw) {
        return this.feedbackRepository.getFeedbacks(kw);
    }

    @Override
    public boolean addFeedback(Feedback fdbck) {
        return this.feedbackRepository.addFeedback(fdbck);
    }

    @Override
    public Feedback getFbById(int i) {
        return this.feedbackRepository.getFbById(i);
    }
    
}

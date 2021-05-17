/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.vadilator;

import com.restaurant.pojo.Feedback;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author OS
 */
public class FeedbackValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Feedback.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Feedback f = (Feedback) target;
        if (f.getDescription() != null )
            errors.rejectValue("description", "feedback.description.error.notNullMsg");
    }
    
}

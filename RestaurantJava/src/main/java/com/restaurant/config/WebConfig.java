/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.config;


import com.restaunrant.formatter.CustomerFormatter;
import com.restaunrant.formatter.EmployeeFormatter;
import com.restaunrant.formatter.EventFormatter;
import com.restaunrant.formatter.HallFormatter;
import com.restaunrant.formatter.ServiceFormatter;
import com.restaunrant.formatter.UserFormatter;
import com.restaurant.vadilator.PassValidator;
import com.restaurant.vadilator.WebValidator;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 *
 * @author HP
 */
@EnableTransactionManagement
@EnableWebMvc
@Configuration
@ComponentScan(basePackages
        = {"com.restaurant.controllers",
            "com.restaurant.formatter",
            "com.restaurant.repository",
            "com.restaurant.service"}
)
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //Add file css
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/img/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages");

        return source;

    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver 
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");

        return resolver;
    }
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new EmployeeFormatter());
        registry.addFormatter(new CustomerFormatter());
        registry.addFormatter(new ServiceFormatter());
        registry.addFormatter(new EventFormatter());
        registry.addFormatter(new HallFormatter());
        registry.addFormatter(new UserFormatter());
    }
    @Bean
    public WebValidator userValidator() {
        Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new PassValidator());

        WebValidator validator = new WebValidator();
        validator.setSpringValidators(springValidators);

        return validator;
    }
    @Bean
    public SimpleDateFormat simpleDateFormat() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f;
    }
    
}

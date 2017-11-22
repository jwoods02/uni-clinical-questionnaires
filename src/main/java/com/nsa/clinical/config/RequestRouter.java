package com.nsa.clinical.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by c1645446 on 22/11/2017.
 */
@Configuration
//@EnableWebMvc
public class RequestRouter extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/index/**").setViewName("forward:/index.html");
        registry.addViewController("/create_question/**").setViewName("forward:/create_question.html");
        registry.addViewController("/question_select/**").setViewName("forward:/question_select.html");



    }
}

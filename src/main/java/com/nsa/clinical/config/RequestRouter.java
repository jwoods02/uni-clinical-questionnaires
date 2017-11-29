package com.nsa.clinical.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by c1645446 on 22/11/2017.
 */
@Configuration
public class RequestRouter extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.addViewController("/api/index/**").setViewName("forward:/index.html");
        registry.addViewController("/api/create_question/**").setViewName("forward:/create_question.html");
        registry.addViewController("/api/create_questionnaire/**").setViewName("forward:/create_questionnaire.html");
        registry.addViewController("/api/edit_questionnaire/**").setViewName("forward:/edit_questionnaire.html");
        registry.addViewController("/api/preview_questionnaire/**").setViewName("forward:/preview_questionnaire.html");
    }
}

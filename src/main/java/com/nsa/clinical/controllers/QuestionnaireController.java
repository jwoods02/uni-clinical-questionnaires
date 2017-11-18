package com.nsa.clinical.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by c1571078 on 17/11/2017.
 */
@RestController
@RequestMapping("/api")
public class QuestionnaireController {

    // Declare services/repositories here


    // Instantiate services/repositories here
    @Autowired
    public QuestionnaireController() {


    }

    @RequestMapping("/createQuestionnaire")
    public String helloWorldTest() {

        String testString = "Hello world";
        return testString;

    }
}

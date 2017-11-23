package com.nsa.clinical.controllers;

import com.nsa.clinical.forms.NewQuestionForm;
import com.nsa.clinical.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 21/11/2017.
 */

@RestController
@RequestMapping(path = "/api")
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @RequestMapping(path = "/question", method = RequestMethod.POST)
    public void createQuestion(NewQuestionForm newQuestionForm){
        questionService.newQuestion(newQuestionForm.getDescription());
    }

    // @RequestMapping(path = "/question", method = RequestMethod.GET)
    // Example of different RequestMethod's for different API calls, using HTTP words
}

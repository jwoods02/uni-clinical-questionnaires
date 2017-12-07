package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.forms.NewQuestionForm;
import com.nsa.clinical.forms.UpdateQuestionForm;
import com.nsa.clinical.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by Talha on 21/11/2017.
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
    public ResponseEntity createQuestion(NewQuestionForm newQuestionForm){
        questionService.newQuestion(newQuestionForm);
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(path = "/question/allQuestions/get", method = RequestMethod.GET)
    public @ResponseBody
    List<Question> getAllStoredQuestions(){
        return questionService.retrieveAllQuestions();
    }
    @RequestMapping(path = "/question/updateQuestion", method = RequestMethod.POST)
    public void updateQuestion(UpdateQuestionForm updateQuestionForm){
        questionService.updateQuestion(updateQuestionForm.getQuestionID(),updateQuestionForm.getQuestionName());
    }


    // @RequestMapping(path = "/question", method = RequestMethod.GET)
    // Example of different RequestMethod's for different API calls, using HTTP words
}

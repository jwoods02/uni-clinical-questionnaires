package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.forms.NewQuestionForm;
import com.nsa.clinical.forms.UpdateQuestionForm;
import com.nsa.clinical.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Long createQuestion(NewQuestionForm newQuestionForm){
        Long questionId = questionService.newQuestion(newQuestionForm);
        return questionId;
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

    @RequestMapping(path = "/question/name/{id}", method = RequestMethod.GET)
    public String getQuestionName(@PathVariable Integer id) {

        return questionService.getQuestionName(id.longValue());
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.DELETE)
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @RequestMapping(path = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable Integer id) {

        return questionService.getQuestion(id.longValue());
    }


    // @RequestMapping(path = "/question", method = RequestMethod.GET)
    // Example of different RequestMethod's for different API calls, using HTTP verbs
}

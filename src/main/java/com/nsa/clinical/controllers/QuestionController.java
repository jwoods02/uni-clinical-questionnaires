package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.forms.NewQuestionnaireForm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Talha on 21/11/2017.
 */
@RestController
public class QuestionController {

    @RequestMapping(path = "/questions", method = RequestMethod.GET)
    public List<Question> getQuestions(NewQuestionnaireForm newQuestionnaireForm){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question ("How Old Are You?"));
        questions.add(new Question ("What is Your Name?"));
        questions.add(new Question ("option3"));

        return questions;
    }


}

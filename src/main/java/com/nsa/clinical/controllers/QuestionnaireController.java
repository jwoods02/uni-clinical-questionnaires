package com.nsa.clinical.controllers;

import com.nsa.clinical.forms.NewOptionForm;
import com.nsa.clinical.forms.NewQuestionnaireForm;
import com.nsa.clinical.repositories.QuestionRepository;
import com.nsa.clinical.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by c1673142 on 17-Nov-17.
 */
@RestController
@RequestMapping(path = "/api")
public class QuestionnaireController {
    private QuestionnaireService questionnaireService;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService){
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping(path = "/questionnaire/create", method = RequestMethod.POST)
    public void createQuestionnaire(NewQuestionnaireForm newQuestionnaireForm){
        questionnaireService.newQuestionnaire(newQuestionnaireForm.getDescription());
    }

    @RequestMapping(path = "/option/create", method = RequestMethod.POST)
    public void createOption(NewOptionForm newOptionForm){
        questionnaireService.newQuestionnaire(newOptionForm.getDescription());
    }


}

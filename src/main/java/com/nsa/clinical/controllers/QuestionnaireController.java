package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.forms.GetQuestionnaireForm;
import com.nsa.clinical.forms.NewOptionForm;
import com.nsa.clinical.forms.NewQuestionnaireForm;
import com.nsa.clinical.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by c1673142 on 17-Nov-17.
 */
@RestController
@RequestMapping(path = "/api")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService){
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping(path = "/questionnaire/create", method = RequestMethod.POST)
    public void createQuestionnaire(NewQuestionnaireForm newQuestionnaireForm){
        questionnaireService.newQuestionnaire(newQuestionnaireForm.getDescription());
    }

    @RequestMapping(path = "questionnaire/get", method = RequestMethod.GET)
    public @ResponseBody Questionnaire getQuestionnaire(GetQuestionnaireForm getQuestionnaireForm, HttpServletRequest request, HttpServletResponse response){
        System.out.println(getQuestionnaireForm.getId());
        System.out.println(questionnaireService.retrieveQuestionnaire(getQuestionnaireForm.getId()).getQuestionnaireDescription());
        return questionnaireService.retrieveQuestionnaire(getQuestionnaireForm.getId());
    }

    @RequestMapping(path = "/option/create", method = RequestMethod.POST)
    public void createOption(NewOptionForm newOptionForm){
        questionnaireService.newQuestionnaire(newOptionForm.getDescription());
    }


}

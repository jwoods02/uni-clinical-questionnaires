package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.forms.GetQuestionnaireForm;
import com.nsa.clinical.forms.NewQuestionnaireForm;
import com.nsa.clinical.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by c1673142 on 17-Nov-17.
 */
@RestController
@RequestMapping(path = "/api")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @RequestMapping(path = "/questionnaire/create", method = RequestMethod.POST)
    public void createQuestionnaire(NewQuestionnaireForm newQuestionnaireForm) {
        questionnaireService.newQuestionnaire(newQuestionnaireForm.getDescription());
    }

    @RequestMapping(path = "/questionnaire/get", method = RequestMethod.GET)
    public
    @ResponseBody
    Questionnaire getQuestionnaire(GetQuestionnaireForm getQuestionnaireForm, HttpServletRequest request, HttpServletResponse response) {
        return questionnaireService.retrieveQuestionnaire(getQuestionnaireForm.getId());
    }

    @RequestMapping(path = "/questionnaire/allQuestionnaires/get", method = RequestMethod.GET)
    public @ResponseBody List<Questionnaire> getAllStoredQuestionnaires(){
        return questionnaireService.retrieveAllQuestionnaires();
    }

    @RequestMapping(path = "/questionnaire/delete", method = RequestMethod.POST)
    public void deleteQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireService.retrieveQuestionnaire(id);

        if (questionnaire != null) {
            questionnaireService.deleteQuestionnaire(questionnaire.getQuestionnaireId());
        } else {
            throw new ResourceNotFoundException();
        }
    }
}

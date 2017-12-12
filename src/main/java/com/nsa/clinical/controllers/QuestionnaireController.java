package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.forms.GetQuestionnaireForm;
import com.nsa.clinical.forms.NewQuestionnaireForm;
import com.nsa.clinical.forms.UpdateQuestionnaireForm;
import com.nsa.clinical.services.QuestionService;
import com.nsa.clinical.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

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
    private QuestionService questionService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService, QuestionService questionService) {
        this.questionnaireService = questionnaireService;
        this.questionService = questionService;
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.POST)
    public void createQuestionnaire(NewQuestionnaireForm newQuestionnaireForm) {
        List<Question> questionList = questionService.getQuestionsFromIds(newQuestionnaireForm.getQuestionIdList());
        questionnaireService.newQuestionnaire(newQuestionnaireForm.getQuestionnaireTitle(), questionList);
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.PUT)
    public void updateQuestionnaire(UpdateQuestionnaireForm updateQuestionnaireForm) {
        List<Question> questionList = questionService.getQuestionsFromIds(updateQuestionnaireForm.getQuestionIdList());
        questionnaireService.updateQuestionnaire(updateQuestionnaireForm.getQuestionnaireId(), updateQuestionnaireForm.getQuestionnaireTitle(), questionList);
    }

    @RequestMapping(path = "/questionnaire/get", method = RequestMethod.GET)
    public
    @ResponseBody
    Questionnaire getQuestionnaire(GetQuestionnaireForm getQuestionnaireForm, HttpServletRequest request, HttpServletResponse response) {
        return questionnaireService.retrieveQuestionnaire(getQuestionnaireForm.getId());
    }

    @RequestMapping(path = "/questionnaire/questions/{id}", method = RequestMethod.GET)
    public List<Question> getAllQuestionsInQuestionnaire(@PathVariable Integer id) {
        return questionnaireService.retrieveAllQuestionsInQuestionnaire(id.longValue());
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

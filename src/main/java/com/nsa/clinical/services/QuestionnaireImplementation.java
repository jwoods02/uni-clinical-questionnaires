package com.nsa.clinical.services;

import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by c1673142 on 17-Nov-17.
 */

@Service
public class QuestionnaireImplementation implements QuestionnaireService {
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireImplementation(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public void newQuestionnaire(String description){
        Questionnaire newQuestionnaire = new Questionnaire();
        newQuestionnaire.setQuestionnaireDescription(description);
        questionnaireRepository.saveAndFlush(newQuestionnaire);
    }

}

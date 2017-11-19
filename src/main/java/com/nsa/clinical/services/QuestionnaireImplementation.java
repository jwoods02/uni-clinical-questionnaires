package com.nsa.clinical.services;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.repositories.QuestionRepository;
import com.nsa.clinical.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by c1673142 on 17-Nov-17.
 */

@Service
public class QuestionnaireImplementation implements QuestionnaireService {
    private QuestionnaireRepository questionnaireRepository;
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionnaireImplementation(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public void newQuestionnaire(String description){
        Questionnaire newQuestionnaire = new Questionnaire();
        newQuestionnaire.setQuestionnaireDescription(description);
        questionnaireRepository.saveAndFlush(newQuestionnaire);
    }
}

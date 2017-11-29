package com.nsa.clinical.services;

import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Questionnaire retrieveQuestionnaire(Long QuestionnaireId){
        return questionnaireRepository.findByQuestionnaireId(QuestionnaireId);
    }

    @Override
    public List<Questionnaire> retrieveAllQuestionnaires () {
        return questionnaireRepository.findAll();
    }

    @Override
    public void deleteQuestionnaire(Long id) {
        questionnaireRepository.delete(id);
    }

}

package com.nsa.clinical.services;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.repositories.QuestionRepository;
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
    public QuestionnaireImplementation(QuestionnaireRepository questionnaireRepository, QuestionRepository questionRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public void newQuestionnaire(String title, List<Question> questionList){
        Questionnaire newQuestionnaire = new Questionnaire();
        newQuestionnaire.setQuestionnaireTitle(title);
        newQuestionnaire.setQuestions(questionList);
        for(Question question: questionList) {
            question.setQuestionnaire(newQuestionnaire);
        }
        questionnaireRepository.saveAndFlush(newQuestionnaire);

//       TODO:
//       Save question order in questionnaire
//       Saved changes alert
    }

    @Override
    public void updateQuestionnaire(Long id, String title, List<Question> questionList) {
        Questionnaire updateQuestionnaire = questionnaireRepository.findByQuestionnaireId(id);
        updateQuestionnaire.setQuestionnaireTitle(title);
        updateQuestionnaire.setQuestions(questionList);
        for(Question question: questionList) {
            question.setQuestionnaire(updateQuestionnaire);
        }
        questionnaireRepository.saveAndFlush(updateQuestionnaire);

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

    @Override
    public List<Question> retrieveAllQuestionsInQuestionnaire(Long id) {
        Questionnaire questionnaire = questionnaireRepository.findByQuestionnaireId(id);

        return questionnaire.getQuestions();
    }
}

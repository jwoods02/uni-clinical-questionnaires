package com.nsa.clinical.services;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.repositories.QuestionRepository;
import com.nsa.clinical.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by James on 21/11/2017.
 */

@Service
public class QuestionImplementation implements QuestionService {
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionImplementation(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void newQuestion(String description){
        Question newQuestion = new Question();
        newQuestion.setQuestionDescription(description);
        questionRepository.saveAndFlush(newQuestion);
    }

    @Override
    public Question retrieveQuestion(Long QuestionId){
        return questionRepository.findByQuestionId(QuestionId);
    }

    @Override
    public List<Question> retrieveAllQuestions () {
        return questionRepository.findAll();
    }

    @Override
    public void updateQuestion(Long questionID, String questionName){
        Question question = questionRepository.findByQuestionId(questionID);
        question.setQuestionDescription(questionName);
        questionRepository.saveAndFlush(question);
    }
}

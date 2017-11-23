package com.nsa.clinical.services;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

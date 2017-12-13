package com.nsa.clinical.services;

import com.nsa.clinical.entities.Option;
import com.nsa.clinical.entities.Question;
import com.nsa.clinical.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by James on 21/11/2017.
 */

@Service
public class OptionImplementation implements  OptionService {
    private OptionRepository optionRepository;
    private QuestionService questionService;

    @Autowired
    public OptionImplementation(OptionRepository optionRepository, QuestionService questionService) {
        this.optionRepository = optionRepository;
        this.questionService = questionService;
    }


    @Override
    public List<Option> getAllOptionsByQuestion(Long questionId) {
        Question question = questionService.getQuestion(questionId);
        return optionRepository.findAllByQuestion(question);
    }
}

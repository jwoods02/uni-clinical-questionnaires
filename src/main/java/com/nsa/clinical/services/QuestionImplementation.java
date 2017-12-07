package com.nsa.clinical.services;

import com.nsa.clinical.entities.Option;
import com.nsa.clinical.entities.Question;
import com.nsa.clinical.forms.NewQuestionForm;
import com.nsa.clinical.repositories.QuestionRepository;
import com.nsa.clinical.repositories.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void newQuestion(NewQuestionForm form){
        List<List> unconvertedOptions = form.getOptions();
        Integer type = form.getQuestionType();
        String questionDescription = form.getQuestionDescription();
        Question newQuestion = new Question(questionDescription, type);

        List<Option> newOptions = new ArrayList<>();

        if((type == 1 )|| (type == 4)) {
            for (List unconvertedOption : unconvertedOptions) {
                String optionDescription = (String) unconvertedOption.get(0);
                Integer order = (Integer) unconvertedOption.get(1);

                Option newOption = new Option(optionDescription, order, newQuestion);
                newOptions.add(newOption);
            }

            newQuestion.setOptions(newOptions);
            questionRepository.saveAndFlush(newQuestion);

        } else if ((type == 2 )|| (type == 3)) {
            questionRepository.saveAndFlush(newQuestion);
        }
    }

    @Override
    public void updateQuestion(Long questionID, String questionName){
        Question question = questionRepository.findByQuestionId(questionID);
        question.setQuestionDescription(questionName);
        questionRepository.saveAndFlush(question);
    }
}

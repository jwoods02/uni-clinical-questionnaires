package com.nsa.clinical.services;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.forms.NewQuestionForm;

import java.util.List;

/**
 * Created by James on 21/11/2017.
 */
public interface QuestionService {
    void newQuestion(NewQuestionForm newQuestionForm);
    Question retrieveQuestion(Long questionId);
    List<Question> retrieveAllQuestions();
    void updateQuestion(Long questionID, String questionName);
}

package com.nsa.clinical.services;

import com.nsa.clinical.forms.NewQuestionForm;

/**
 * Created by James on 21/11/2017.
 */
public interface QuestionService {
    void newQuestion(String description);
    Question retrieveQuestion(Long QuestionId);
    List<Question> retrieveAllQuestions();
    void updateQuestion(Long questionID, String questionName);
}

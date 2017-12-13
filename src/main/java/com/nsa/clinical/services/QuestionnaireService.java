package com.nsa.clinical.services;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;

import java.util.List;

/**
 * Created by c1673142 on 17-Nov-17.
 */
public interface QuestionnaireService {

    void newQuestionnaire(String title, List<Question> questionList);

    void updateQuestionnaire(Long id, String title, List<Question> questionList);

    Questionnaire retrieveQuestionnaire(Long QuestionnaireId);

    List<Questionnaire> retrieveAllQuestionnaires();

    void deleteQuestionnaire(Long id);

    List<Question> retrieveAllQuestionsInQuestionnaire(Long id);


}

package com.nsa.clinical.services;

import com.nsa.clinical.entities.Questionnaire;

/**
 * Created by c1673142 on 17-Nov-17.
 */
public interface QuestionnaireService {
    void newQuestionnaire(String description);
    Questionnaire retrieveQuestionnaire(Long QuestionnaireId);

}

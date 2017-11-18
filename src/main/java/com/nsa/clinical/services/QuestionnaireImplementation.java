package com.nsa.clinical.services;

import com.nsa.clinical.entities.Questionnaire;
import org.springframework.stereotype.Service;
import javax.persistence.*;

/**
 * Created by c1673142 on 17-Nov-17.
 */

@Service
public class QuestionnaireImplementation implements QuestionnaireService {
    //TODO: Link to repository after entities have been created.
    @Override
    public void newQuestionnaire(String description){
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestionnaireDescription(description);
    }
}

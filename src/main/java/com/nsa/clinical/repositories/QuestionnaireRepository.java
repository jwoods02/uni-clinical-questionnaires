package com.nsa.clinical.repositories;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by c1673142 on 19-Nov-17.
 */
public interface QuestionnaireRepository extends JpaRepository<Questionnaire,Long> {
    List<Questionnaire>findAll();
    Questionnaire findByQuestionnaireId(long id);
}

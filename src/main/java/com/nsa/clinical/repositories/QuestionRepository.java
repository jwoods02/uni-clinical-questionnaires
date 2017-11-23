package com.nsa.clinical.repositories;

import com.nsa.clinical.entities.Question;
import com.nsa.clinical.entities.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by c1673142 on 18-Nov-17.
 */
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Question findByQuestionId(long id);
}

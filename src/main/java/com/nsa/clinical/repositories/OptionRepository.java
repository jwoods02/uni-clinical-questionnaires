package com.nsa.clinical.repositories;

import com.nsa.clinical.entities.Option;
import com.nsa.clinical.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by James on 20/11/2017.
 */
    public interface OptionRepository extends JpaRepository<Option,Long> {
    List<Option> findAllByQuestion(Question question);
}

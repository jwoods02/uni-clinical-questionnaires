package com.nsa.clinical.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by c1571078 on 17/11/2017.
 */

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionId;

    @Column(name = "question_description")
    private String questionDescription;

    @ManyToOne
    @JoinColumn(name="questionnaire_id",referencedColumnName="questionnaire_id")
    private Questionnaire questionnaire;

    @ManyToMany
    @JoinTable(name="question_option",
            joinColumns = @JoinColumn(name="question_id", referencedColumnName="question_id"),
            inverseJoinColumns = @JoinColumn(name="option_id", referencedColumnName="option_id"))
    private List<Option> options;
}

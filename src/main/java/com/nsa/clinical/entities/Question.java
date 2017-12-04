package com.nsa.clinical.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long questionId;

    @Column(name = "question_description")
    private String questionDescription;

    @ManyToOne
    @JoinColumn(name="questionnaire_id",referencedColumnName="questionnaire_id")
    private Questionnaire questionnaire;

    @OneToMany(mappedBy="question", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY,targetEntity=Option.class)
    @JsonIgnore
    private List<Option> options;

}

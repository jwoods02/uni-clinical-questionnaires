package com.nsa.clinical.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Column(name = "question_type")
    private Integer questionType;

    @ManyToOne
    @JoinColumn(name="questionnaire_id",referencedColumnName="questionnaire_id")
    private Questionnaire questionnaire;

    @OneToMany(mappedBy="question", cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity=Option.class)
    @JsonIgnore
    private List<Option> options;

    public Question(String questionDescription, Integer questionType, List<Option> options) {
        this.questionDescription = questionDescription;
        this.questionType = questionType;
        this.options = options;
    }

    public Question(String questionDescription, Integer questionType) {
        this.questionDescription = questionDescription;
        this.questionType = questionType;
    }

    public Question() {
    }
}

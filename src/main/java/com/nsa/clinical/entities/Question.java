package com.nsa.clinical.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by c1571078 on 17/11/2017.
 */

@Entity
@Table(name = "Question")
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

    public Question(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Question() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

}

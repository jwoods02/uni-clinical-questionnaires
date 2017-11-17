package com.nsa.clinical.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by c1571078 on 17/11/2017.
 */

@Entity
@Table(name = "Option")
public class Option {

    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer optionId;

    @Column(name = "option_description")
    private String optionDescription;

    @Column(name = "option_type")
    private String optionType;

    @ManyToMany(mappedBy="questions")
    private List<Question> questions;

    public Option(String optionDescription, String optionType) {
        this.optionDescription = optionDescription;
        this.optionType = optionType;
    }

    public Option() {
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

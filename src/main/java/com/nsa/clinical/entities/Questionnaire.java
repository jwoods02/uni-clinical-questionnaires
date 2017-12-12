package com.nsa.clinical.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by c1571078 on 17/11/2017.
 */

@Data
@Entity
@Table(name = "questionnaire")
public class Questionnaire {

    @Id
    @Column(name = "questionnaire_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionnaireId;

    @Column(name = "questionnaire_title")
    private String questionnaireTitle;

    @Column(name = "questionnaire_description")
    private String questionnaireDescription;

    @Column(name = "date_created")
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name="admin_id",referencedColumnName="admin_id")
    private Admin admin;

    @OneToMany(mappedBy="questionnaire", cascade = CascadeType.ALL, fetch = FetchType.LAZY,targetEntity=Question.class)
    @JsonIgnore
    private List<Question> questions;

    public Questionnaire(String questionnaireTitle, List<Question> questions) {
        this.questionnaireTitle = questionnaireTitle;
        this.questions = questions;
    }

    public Questionnaire(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public Questionnaire() {

    }

    public String toString() {
        return "";
    }
}

package com.nsa.clinical.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by c1571078 on 17/11/2017.
 */
@Entity
@Table(name = "Questionnaire")
public class Questionnaire {

    @Id
    @Column(name = "questionnaire_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer questionnaireId;

    @Column(name = "questionnaire_title")
    private String questionnaireTitle;

    @Column(name = "questionnaire_description")
    private String questionnaireDescription;

    @ManyToOne
    @JoinColumn(name="admin_id",referencedColumnName="admin_id")
    private Admin admin;

    @Column(name = "date_created")
    private Date dateCreated;

    @OneToMany(mappedBy="questionnaire",targetEntity=Question.class)
    private List<Question> questions;

    public Questionnaire(String questionnaireTitle, String questionnaireDescription, Date dateCreated) {
        this.questionnaireTitle = questionnaireTitle;
        this.questionnaireDescription = questionnaireDescription;
        this.dateCreated = dateCreated;
    }

    public Questionnaire() {
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionnaireTitle() {
        return questionnaireTitle;
    }

    public void setQuestionnaireTitle(String questionnaireTitle) {
        this.questionnaireTitle = questionnaireTitle;
    }

    public String getQuestionnaireDescription() {
        return questionnaireDescription;
    }

    public void setQuestionnaireDescription(String questionnaireDescription) {
        this.questionnaireDescription = questionnaireDescription;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

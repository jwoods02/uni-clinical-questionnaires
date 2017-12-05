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
@Table(name = "options")
public class Option {

    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long optionId;

    @Column(name = "option_description")
    private String optionDescription;

    @Column(name = "option_type")
    private Integer optionType;

    @Column(name = "option_order")
    private Integer optionOrder;

    @ManyToOne
    @JoinColumn(name="question_id",referencedColumnName="question_id")
    private Question question;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "options")
    private List<Question> questions;
}

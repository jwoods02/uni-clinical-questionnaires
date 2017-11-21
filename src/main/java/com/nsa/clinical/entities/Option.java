package com.nsa.clinical.entities;

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
    private Integer optionId;

    @Column(name = "option_description")
    private String optionDescription;

    @Column(name = "option_type")
    private String optionType;

//    @OneToMany(mappedBy = "option")
//    private List<Question> questions;
}

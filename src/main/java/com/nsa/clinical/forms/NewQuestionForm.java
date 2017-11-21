package com.nsa.clinical.forms;

import com.nsa.clinical.entities.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by James on 21/11/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewQuestionForm {
    private String description;
    private Questionnaire questionnaire;
}

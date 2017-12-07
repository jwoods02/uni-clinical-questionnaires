package com.nsa.clinical.forms;

import com.nsa.clinical.entities.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by c1673142 on 07-Dec-17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateQuestionForm {
    private Long questionID;
    private String questionName;
}

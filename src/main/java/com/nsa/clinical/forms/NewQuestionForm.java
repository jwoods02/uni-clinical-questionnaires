package com.nsa.clinical.forms;

import com.nsa.clinical.entities.Questionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

import java.util.List;
import java.util.Optional;

/**
 * Created by James on 21/11/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewQuestionForm {
    private String questionDescription;
    private Integer questionType;
    private JSONArray options;
    private Questionnaire questionnaire;
}

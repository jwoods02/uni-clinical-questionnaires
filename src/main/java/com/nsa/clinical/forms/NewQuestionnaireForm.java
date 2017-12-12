package com.nsa.clinical.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

/**
 * Created by c1673142 on 19-Nov-17.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewQuestionnaireForm {
    private String questionnaireTitle;
    private JSONArray questionIdList;
}

package com.nsa.clinical.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;

/**
 * Created by James on 08/12/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateQuestionnaireForm {
    private long questionnaireId;
    private String questionnaireTitle;
    private JSONArray questionIdList;
}

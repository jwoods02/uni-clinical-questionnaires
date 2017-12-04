package com.nsa.clinical.forms;

import com.nsa.clinical.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by James on 20/11/2017.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewOptionForm {
    private Integer optionType;
    private String optionDescription;
    private Integer optionOrder;
    private Question question;
}

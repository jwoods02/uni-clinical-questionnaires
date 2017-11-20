package com.nsa.clinical.forms;

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
    private String description;
    private Integer type;
}

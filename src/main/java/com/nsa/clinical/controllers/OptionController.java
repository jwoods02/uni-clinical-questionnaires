package com.nsa.clinical.controllers;

import com.nsa.clinical.forms.NewOptionForm;
import com.nsa.clinical.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 21/11/2017.
 */

@RestController
@RequestMapping(path = "/api")
public class OptionController {

    private OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService){
        this.optionService = optionService;
    }

    @RequestMapping(path = "/option", method = RequestMethod.POST)
    public void createQuestion(NewOptionForm newOptionForm){
        optionService.newOption(newOptionForm.getDescription(), newOptionForm.getType());
    }
}

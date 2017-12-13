package com.nsa.clinical.controllers;

import com.nsa.clinical.entities.Option;
import com.nsa.clinical.forms.NewOptionForm;
import com.nsa.clinical.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(path = "/options/{questionId}", method = RequestMethod.GET)
    public @ResponseBody List<Option> retrieveAllOptionsByQuestion(@PathVariable Integer questionId){
        return optionService.getAllOptionsByQuestion(questionId.longValue());
    }
}

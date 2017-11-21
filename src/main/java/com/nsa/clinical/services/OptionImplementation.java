package com.nsa.clinical.services;

import com.nsa.clinical.entities.Option;
import com.nsa.clinical.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by James on 21/11/2017.
 */

@Service
public class OptionImplementation implements  OptionService {
    private OptionRepository optionRepository;

    @Autowired
    public OptionImplementation(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public void newOption(String description, Integer type) {
        Option newOption = new Option();
        newOption.setOptionDescription(description);
        newOption.setOptionType(type.toString());
    }


}

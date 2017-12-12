package com.nsa.clinical.services;

import com.nsa.clinical.entities.Option;

import java.util.List;

/**
 * Created by James on 21/11/2017.
 */
public interface OptionService {
    List<Option> getAllOptionsByQuestion(Long questionId);

}

package com.nsa.clinical.controllers;

import com.nsa.clinical.services.QuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by James on 28/11/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class TestQuestionController {

    @Autowired
    private MockMvc mvc;

    @MockBean
    QuestionService questionService;

    @Test
    public void expectToSee() throws Exception {

    }

}

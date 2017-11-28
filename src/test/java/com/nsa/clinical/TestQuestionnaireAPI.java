package com.nsa.clinical;

import com.nsa.clinical.controllers.QuestionnaireController;
import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.services.QuestionnaireService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by c1571078 on 27/11/2017.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionnaireController.class)
public class TestQuestionnaireAPI {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private QuestionnaireService questionnaireService;

    @Test
    public void expectToSeeAllQuestionnaireNamesInResponse() throws Exception {

        Questionnaire a = new Questionnaire("Questionnaire 1");
        Questionnaire b = new Questionnaire("Questionnaire 2");
        List<Questionnaire> testList = new ArrayList<>();
        testList.add(a);
        testList.add(b);

        given(this.questionnaireService.retrieveAllQuestionnaires()).willReturn(testList);

        mvc.perform(MockMvcRequestBuilders.get("/api/preview_questionnaire/get").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Questionnaire 1")))
                .andExpect(content().string(containsString("Questionnaire 2")))
        ;
    }

}

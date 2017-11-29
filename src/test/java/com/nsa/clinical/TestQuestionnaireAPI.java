package com.nsa.clinical;

import com.nsa.clinical.controllers.QuestionnaireController;
import com.nsa.clinical.entities.Questionnaire;
import com.nsa.clinical.services.QuestionnaireService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
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

    // Referenced from https://gitlab.cs.cf.ac.uk/scmcj1/CM6213Exercise2
    @Test
    public void expectToSeeAllQuestionnaireInResponse() throws Exception {
        Questionnaire a = new Questionnaire("Questionnaire 1");
        Questionnaire b = new Questionnaire("Questionnaire 2");
        List<Questionnaire> testList = new ArrayList<>();
        testList.add(a);
        testList.add(b);

        given(this.questionnaireService.retrieveAllQuestionnaires()).willReturn(testList);

        mvc.perform(MockMvcRequestBuilders.get("/api/questionnaire/allQuestionnaires/get").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Questionnaire 1")))
                .andExpect(content().string(containsString("Questionnaire 2")))
        ;
    }

    // Referenced from https://memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/#unit-test-http-delete
    @Test
    public void expectQuestionnaireToBeDeletedSuccessfully() throws Exception {
        Questionnaire testQuestionnaire = new Questionnaire("testQuestionnaire");
        when(questionnaireService.retrieveQuestionnaire(testQuestionnaire.getQuestionnaireId())).thenReturn(testQuestionnaire);
        doNothing().when(questionnaireService).deleteQuestionnaire(testQuestionnaire.getQuestionnaireId());
        mvc.perform(MockMvcRequestBuilders.post("/api/questionnaire/delete", testQuestionnaire.getQuestionnaireId()))
                .andExpect(status().isOk());
        verify(questionnaireService, times(1)).retrieveQuestionnaire(testQuestionnaire.getQuestionnaireId());
        verify(questionnaireService, times(1)).deleteQuestionnaire(testQuestionnaire.getQuestionnaireId());
        verifyNoMoreInteractions(questionnaireService);
    }
}

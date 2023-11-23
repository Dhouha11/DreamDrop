package com.dreamdrop.dreamdrop;
import com.dreamdrop.dreamdrop.controller.InterventionController;
import com.dreamdrop.dreamdrop.model.Intervention;
import com.dreamdrop.dreamdrop.service.InterventionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(InterventionController.class)
public class InterventionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InterventionService interventionService;

    @Test
    public void getAllInterventions_ShouldReturnListOfInterventions() throws Exception {
        // Arrange
        Intervention intervention1 = new Intervention();
        intervention1.setId(1);
        intervention1.setTitre("Intervention 1");

        Intervention intervention2 = new Intervention();
        intervention2.setId(2);
        intervention2.setTitre("Intervention 2");

        List<Intervention> interventions = Arrays.asList(intervention1, intervention2);

        Mockito.when(interventionService.getAllInterventions()).thenReturn(interventions);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/interventions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(interventions.size()));
    }


}


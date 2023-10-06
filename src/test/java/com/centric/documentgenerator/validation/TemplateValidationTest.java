package com.centric.documentgenerator.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.TreeSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TemplateValidationTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void extractedTagsTest() throws Exception{
      TreeSet<String> expectedResponse = new TreeSet<>();
        expectedResponse.add("James");
        expectedResponse.add("John");
      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/template-validation")
               .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
               .andReturn();
      String response = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        String[] namesArray = objectMapper.readValue(response, String[].class);
        TreeSet<String> actualResponse = new TreeSet<>(Arrays.asList(namesArray));
        // Create a TreeSet with the expected values

        System.out.println(actualResponse + "Actual");
        System.out.println(expectedResponse + "expected");
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

}

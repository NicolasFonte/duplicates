package com.nicolasf.duplicates.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.nicolasf.duplicates.service.DuplicatesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DuplicatesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DuplicatesService duplicatesService;

    @Before
    public void setUp() {
        DuplicatesController imageController = new DuplicatesController(duplicatesService);
        mockMvc = standaloneSetup(imageController).build();
    }

    @Test
    public void getFromIndex() throws Exception {
        Mockito.when(duplicatesService.getFromIndex(1)).thenReturn("A");

        mockMvc.perform(get("/v1/api/duplicates/1"))
                .andExpect(MockMvcResultMatchers.content().string("A"))
                .andExpect(status().isOk());
    }

}
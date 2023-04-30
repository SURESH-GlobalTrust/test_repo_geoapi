package com.globaltrust.geodata;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import  com.globaltrust.geodata.controllers.CSVDataController;
@WebMvcTest(CSVDataController.class)
public class CSVDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCSVGetFacilities() throws Exception {
        mockMvc.perform(get("/api/csv/getfacilities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM))
                .andExpect(header().string("Content-Disposition", "attachment; filename=facilities.csv"))
        // add more assertions as needed for the CSV file content
        ;
    }
}

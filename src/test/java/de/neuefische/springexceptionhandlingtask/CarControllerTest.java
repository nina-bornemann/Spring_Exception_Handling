package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCarBrand_shouldReturn_IllegalArgumentException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars/Opel"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(""" 
                                                    {
                                                        "errorMessage": "Only 'porsche' allowed"
                                                     }"""))
                .andExpect(MockMvcResultMatchers.jsonPath("$.instant").isNotEmpty());
    }

    @Test
    void getAllCars_shouldReturn_NoSuchElementException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cars"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().json("""
                                                                           {
                                                                             "errorMessage": "No cars were found."
                                                                           }
                                                                           """))
                .andExpect(MockMvcResultMatchers.jsonPath("$.instant").isNotEmpty());
    }
}
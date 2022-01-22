/*
 * Copyright 2022 terry.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ec.edu.espe.arquitectura.examen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import ec.edu.espe.arquitectura.examen.model.Estudiante;
import ec.edu.espe.arquitectura.examen.service.EstudianteService;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author terry
 */
@WebMvcTest(EstudianteController.class)
public class EstudianteControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    EstudianteService service;
    @InjectMocks
    Estudiante estudiante;

    
    public EstudianteControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
     MockitoAnnotations.initMocks(this);
     Date fechacreacion = new Date();
      Date fechanacimiento = new Date();
     estudiante.setCorreo("crvillarreal1@espe.edu.ec");
     estudiante.setEstado("ACT");
     estudiante.setFechacreacion(fechacreacion);
     estudiante.setFechanacimiento(fechanacimiento);
     estudiante.setId("3");
     estudiante.setPais("593");
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createEstudiante method, of class EstudianteController.
     */
    @Test
    public void CreateEstudianteTest() throws Exception {
  when(service.crateEstudiante(estudiante)).thenReturn(estudiante);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestBody = ow.writeValueAsString(estudiante);
        mvc.perform(post("/api/v1/estudiante")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());

    }
    
       @Test
    public void  failedCreateEstudianteTest() throws Exception {
  when(service.crateEstudiante(estudiante)).thenThrow(Exception.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestBody = ow.writeValueAsString(estudiante);
        mvc.perform(post("/api/v1/estudiante")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());

    }
}

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
import ec.edu.espe.arquitectura.examen.model.Curso;
import ec.edu.espe.arquitectura.examen.model.Estudiante;
import ec.edu.espe.arquitectura.examen.service.CursoService;
import ec.edu.espe.arquitectura.examen.service.EstudianteService;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
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
public class CursoControllerTest {
      @Autowired
    private MockMvc mvc;

    @MockBean
    CursoService service;
    @InjectMocks
    Curso curso;

    public CursoControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of buscarPorArea method, of class CursoController.
     */
    @Test

    public void testBuscarPorArea() throws Exception {
        String area="MATEMATICA";
        when(service.buscarPorArea(area)).thenReturn(List.of(curso));
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestBody = ow.writeValueAsString(area);
        mvc.perform(post("/api/v1/estudiante")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());

    }

    /**
     * Test of buscarPorNombre method, of class CursoController.
     */

    public void testBuscarPorNombre() {
        System.out.println("buscarPorNombre");
        String nombre = "";
        CursoController instance = new CursoController();
        ResponseEntity<List<Curso>> expResult = null;
        ResponseEntity<List<Curso>> result = instance.buscarPorNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

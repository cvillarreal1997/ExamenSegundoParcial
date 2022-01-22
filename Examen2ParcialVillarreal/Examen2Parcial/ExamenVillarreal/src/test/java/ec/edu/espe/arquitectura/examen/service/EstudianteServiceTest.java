/*
 * Copyright (c) 2022 mafer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    mafer - initial API and implementation and/or initial documentation
 */


import ec.edu.espe.arquitectura.examen.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen.exception.CreateException;
import ec.edu.espe.arquitectura.examen.model.Estudiante;
import ec.edu.espe.arquitectura.examen.service.EstudianteService;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    
    @Mock
    EstudianteRepository repo;
    
    @InjectMocks
    EstudianteService service;
    Estudiante estudiante,es;
    
    @BeforeEach
    void setUp() {

        String fecha = "2018-11-09";
        Date fechaNacimiento = new Date();
        Date fechaCreacion=new Date();
        estudiante = new Estudiante();
        estudiante.setCorreo("crvillarreal1@espe.edu.ec");
        estudiante.setFechanacimiento(fechaNacimiento);
        estudiante.setNombres("Carlos Ramiro");
        estudiante.setPais("593");
        estudiante.setFechacreacion(fechaCreacion);
        

    }
    
    @Test
    void crearEstudianteTest() throws Exception{
        when(repo.findByCorreo("crvillarreal1@espe.edu.ec")).thenReturn(estudiante);
        when(repo.save(estudiante)).thenReturn(estudiante);
        this.service.crateEstudiante(estudiante);
    }
    
    @Test
    void crearEstudianteTestException(){
        lenient().when(repo.findByCorreo("crvillarreal1@espe.edu.ec")).thenReturn(estudianteEj);
        when(repo.save(estudiante)).thenThrow(CreateException.class);
        Assertions.assertThrows(CreateException.class, () -> {
            this.service.crateEstudiante(estudiante);
        });
    }
}
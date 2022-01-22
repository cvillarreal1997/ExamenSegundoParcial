/*
 * Copyright 2021 jdismael.
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

import ec.edu.espe.arquitectura.examen.dto.EstudianteDto;
import ec.edu.espe.arquitectura.examen.model.Estudiante;
import ec.edu.espe.arquitectura.examen.service.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jdismael
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/estudiante")
@Tag(name = "Personas", description = "Endpoints para la gestión de personas")
public class EstudianteController {
    final private EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    
   

    
    @PostMapping
    @Operation(
            summary = "Crea un Estudiante",
            description = "Crea un estudiante",
            tags = {"Personas"},
            responses = {
                    @ApiResponse(
                            description = "Ok, cuando se crea un estudiante exitosamente",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Estudiante.class))
                    ),
                    @ApiResponse(
                            description = "Ocurrió un error al momento de crear el estudiante",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public ResponseEntity createEstudiante(@RequestBody @Parameter(description = "La información del estudiante a crear",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {
        try {
            this.service.crateEstudiante(estudiante);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Ocurrio un error al crear el estudiante "
                    + "{} - retorna badrequest", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
       @PostMapping("inscribir")
    public ResponseEntity<Estudiante> inscribirEstudiante(@RequestBody EstudianteDto estudianteDto) {
        try {
            return ResponseEntity.ok().body(this.service.saveEstudiante(estudianteDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    


    
    
}

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
package ec.edu.espe.arquitectura.examen.service;

import ec.edu.espe.arquitectura.examen.model.Estudiante;
import org.springframework.stereotype.Service;
import ec.edu.espe.arquitectura.examen.dao.EstudianteRepository;
import ec.edu.espe.arquitectura.examen.dto.EstudianteDto;
import ec.edu.espe.arquitectura.examen.exception.EntityExistsException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author jdismael
 */
@Service
public class EstudianteService {

    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public Optional<Estudiante> findEstudiante(String correo) {
        return repo.findByCorreo(correo);

    }

    public Estudiante crateEstudiante(Estudiante estudiante) throws Exception {
        Date fechacreacion=new Date();
        estudiante.setFechacreacion(fechacreacion);
        if (findEstudiante(estudiante.getCorreo()) == null) {
            throw new Exception();
        }
        return this.repo.save(estudiante);

}
    
        public Estudiante saveEstudiante(EstudianteDto estudianteDto) {
        Optional<Estudiante> estudiante = this.repo.findByCorreo(estudianteDto.getCorreo());
        if(estudiante.isEmpty()) {
            throw new EntityExistsException("Hay un estudiante con ese correo");
        }
        return this.repo.save(estudiante.get());
    }
}
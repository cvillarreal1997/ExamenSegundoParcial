package ec.edu.espe.arquitectura.examen.dao;

import ec.edu.espe.arquitectura.examen.model.Curso;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface CursoRepository extends MongoRepository<Curso, String> {
    List<Curso> findByAreaAndFechaInicioGreaterThan(String area, Date fechaInicio);
    List<Curso> findByNombreLikeAndFechaInicioGreaterThan(String nombre, Date fechaInicio);
    Optional<Curso> findByCodigo(String codigo);
}

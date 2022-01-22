package ec.edu.espe.arquitectura.examen.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Matricula {
    private Matricula matricula;
    @DBRef(lazy = true)
    private Curso curso;
    private Boolean estado;
    private Date fechaMatricula;
}

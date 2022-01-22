package ec.edu.espe.arquitectura.examen.dto;

import ec.edu.espe.arquitectura.examen.model.Matricula;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InformacionMatriculaDto {
    private String nombreEstudiante;
    private Matricula matricula;
}

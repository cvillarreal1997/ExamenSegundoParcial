package ec.edu.espe.arquitectura.examen.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MatriculaDto {
    String idEstudiante;
    String idCurso;
}

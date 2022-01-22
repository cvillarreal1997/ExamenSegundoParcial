/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.examen.model;

import java.time.LocalDate;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author jdismael
 */
@Data
@Document(collection = "estudiantes")
public class Estudiante {

    @Id
    private String id;
    private String nombres;
    private String correo;
    private String pais;
    private Date fechanacimiento;
    private Date fechacreacion;
    private String estado;
  
  
}

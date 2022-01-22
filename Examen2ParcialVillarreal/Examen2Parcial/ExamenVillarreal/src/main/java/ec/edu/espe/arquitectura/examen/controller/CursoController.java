package ec.edu.espe.arquitectura.examen.controller;

import ec.edu.espe.arquitectura.examen.model.Curso;
import ec.edu.espe.arquitectura.examen.service.CursoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/curso/")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping("area")
    public ResponseEntity<List<Curso>> buscarPorArea(@RequestParam String area) {
        return ResponseEntity.ok().body(this.cursoService.buscarPorArea(area));
    }

    @GetMapping("nombre")
    public ResponseEntity<List<Curso>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok().body(this.cursoService.buscarPorNombre(nombre));
    }
}

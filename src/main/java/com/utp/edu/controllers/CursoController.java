package com.utp.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.edu.models.Curso;
import com.utp.edu.services.CursoService;

@RestController
@RequestMapping("/curso")
@CrossOrigin("*")
public class CursoController {
    
    @Autowired
    private CursoService cursoService;

    @PostMapping("/")
    public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.agregarCurso(curso));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCursos() {
        return ResponseEntity.ok(cursoService.obtenerCursos());
    }

    @GetMapping("/{cursoId}")
    public Curso listaCursoPorId(@PathVariable("cursoId") Long cursoId) {
        return cursoService.obteneCurso(cursoId);
    }

    @PutMapping("/")
    public Curso actualizarCurso(@RequestBody Curso curso) {
        return cursoService.actualizarCurso(curso);
    }

    @DeleteMapping("/{cursoId}")
    public void eliminarCurso(@PathVariable("cursoId") Long cursoId) {
        cursoService.eliminarCurso(cursoId);
    }
}

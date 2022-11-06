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

import com.utp.edu.models.Estudiante;
import com.utp.edu.services.EstudianteService;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin("*")
public class EstudianteController {
    
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/")
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.agregarEstudiante(estudiante));
    }

    @PutMapping("/")
    public ResponseEntity<Estudiante> actualizarProducto(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.actualizarEstudiante(estudiante));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarEstudiantes() {
        return ResponseEntity.ok(estudianteService.obtenerEstudiantes());
    }

    @GetMapping("/{estudianteId}")
    public Estudiante listarEstudiantePorId(@PathVariable("estudianteId") Long estudianteId) {
        return estudianteService.obtenerEstudiante(estudianteId);
    }

    @DeleteMapping("/{estudianteId}")
    public void eliminarEstudiante(@PathVariable("estudianteId") Long estudianteId) {
        estudianteService.eliminarEstudiante(estudianteId);
    }
}

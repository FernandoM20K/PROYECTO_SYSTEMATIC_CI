package com.utp.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utp.edu.models.CursoVenta;
import com.utp.edu.services.CursoVentaService;

@RestController
@RequestMapping("/cursoVenta")
@CrossOrigin("*")
public class CursoVentaController {
    
    @Autowired
    private CursoVentaService cursoVentaService;

    @PostMapping("/")
    public ResponseEntity<CursoVenta> guardarCursoVenta(@RequestBody CursoVenta cursoVenta) {
        return ResponseEntity.ok(cursoVentaService.agregaCursoVenta(cursoVenta));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarCursosEnVenta() {
        return ResponseEntity.ok(cursoVentaService.obtenerCursosVenta());
    }

    @GetMapping("/{cursoVentaId}")
    public CursoVenta listarCursoEnVentaPorId(@PathVariable("cursoVentaId") Long cursoVentaId) {
        return cursoVentaService.obtenerCursoVenta(cursoVentaId);
    }
}

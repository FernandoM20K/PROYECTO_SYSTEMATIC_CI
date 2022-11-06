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

import com.utp.edu.models.Sede;
import com.utp.edu.services.SedeService;

@RestController
@RequestMapping("/sede")
@CrossOrigin("*")

public class SedeController {
    
    @Autowired
    private SedeService sedeService;

    @PostMapping("/")
    public ResponseEntity<Sede> guardarSede(@RequestBody Sede sede) {
        return ResponseEntity.ok(sedeService.agregarSede(sede));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarSedes() {
        return ResponseEntity.ok(sedeService.obtenerSedes());
    }

    @GetMapping("/{sedeId}")
    public Sede listarSedePorId(@PathVariable("sedeId") Long sedeId) {
        return sedeService.obtenerSede(sedeId);
    }

    @PutMapping("/")
    public Sede actualizarSede(@RequestBody Sede sede) {
        return sedeService.actualizarSede(sede);
    }

    @DeleteMapping("/{sedeId}")
    public void eliminarSede(@PathVariable("sedeId") Long sedeId) {
        sedeService.eliminarSede(sedeId);
    }

}

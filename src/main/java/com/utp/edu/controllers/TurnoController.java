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
import com.utp.edu.models.Turno;
import com.utp.edu.services.TurnoService;

@RestController
@RequestMapping("/turno")
@CrossOrigin("*")
public class TurnoController {
    
    @Autowired
    private TurnoService turnoService;

    @PostMapping("/")
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno) {
        Turno turnoGuardada = turnoService.agregarTurno(turno);
        return ResponseEntity.ok(turnoGuardada);
    }

    @GetMapping("/{turnoId}")
    public Turno listTurnoPorId(@PathVariable("turnoId") Long turnoId) {
        return turnoService.obteneTurno(turnoId);
    }

    @GetMapping("/")
    public ResponseEntity<?> listarTurno() {
        return ResponseEntity.ok(turnoService.obtenerTurnos());
    }

    @PutMapping("/")
    public Turno actualizaTurno(@RequestBody Turno turno) {
        return turnoService.actualizarTurno(turno);
    }

    @DeleteMapping("/{turnoId}")
    public void eliminarTurno(@PathVariable("turnoId") Long turnoId) {
        turnoService.eliminarTurno(turnoId);
    }
}

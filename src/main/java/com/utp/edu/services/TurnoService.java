package com.utp.edu.services;

import java.util.Set;
import com.utp.edu.models.Turno;

public interface TurnoService {
    Turno agregarTurno(Turno turno);
    Turno actualizarTurno(Turno turno);
    Set<Turno> obtenerTurnos();
    Turno obteneTurno(Long turnoId);
    void eliminarTurno(Long turnoId);
}

package com.utp.edu.services;

import java.util.Set;

import com.utp.edu.models.Profesor;

public interface ProfesorService {
    Profesor agregarProfesor(Profesor profesor);
    Profesor actualizarProfesor(Profesor profesor);
    Set<Profesor> obtenerProfesores();
    Profesor obteneProfesor(Long profesorId);
    void eliminarProfesor(Long profesorId);
}

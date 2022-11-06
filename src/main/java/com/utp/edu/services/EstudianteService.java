package com.utp.edu.services;

import java.util.Set;

import com.utp.edu.models.Estudiante;

public interface EstudianteService {
    Estudiante agregarEstudiante(Estudiante estudiante);
    Estudiante actualizarEstudiante(Estudiante estudiante);
    Set<Estudiante> obtenerEstudiantes();
    Estudiante obtenerEstudiante(Long estudianteId);
    void eliminarEstudiante(Long estudianteId);
}

package com.utp.edu.services;

import java.util.Set;

import com.utp.edu.models.Curso;

public interface CursoService {
    Curso agregarCurso(Curso curso);
    Curso actualizarCurso(Curso curso);
    Set<Curso> obtenerCursos();
    Curso obteneCurso(Long cursoId);
    void eliminarCurso(Long cursoId);
}

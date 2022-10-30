package com.utp.edu.services;

import java.util.Set;

import com.utp.edu.models.CursoVenta;

public interface CursoVentaService {
    CursoVenta agregaCursoVenta(CursoVenta cursoVenta);
    CursoVenta actualizaCursoVenta(CursoVenta cursoVenta);
    Set<CursoVenta> obtenerCursosVenta();
    CursoVenta obtenerCursoVenta(Long cursoVentaId);
    void eliminarCursoVenta(Long cursoVentaId);
}

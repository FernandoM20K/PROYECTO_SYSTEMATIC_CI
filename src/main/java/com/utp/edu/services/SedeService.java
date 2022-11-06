package com.utp.edu.services;

import java.util.Set;

import com.utp.edu.models.Sede;

public interface SedeService {
    Sede agregarSede(Sede sede);
    Sede actualizarSede(Sede sede);
    Set<Sede> obtenerSedes();
    Sede obtenerSede(Long sedeId);
    void eliminarSede(Long sedeId);
}

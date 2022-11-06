package com.utp.edu.services.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.edu.models.Estudiante;
import com.utp.edu.repositorys.EstudianteRepository;
import com.utp.edu.services.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante agregarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Set<Estudiante> obtenerEstudiantes() {
        return new LinkedHashSet<>(estudianteRepository.findAll());
    }

    @Override
    public Estudiante obtenerEstudiante(Long estudianteId) {
        return estudianteRepository.findById(estudianteId).get();
    }

    @Override
    public void eliminarEstudiante(Long estudianteId) {
        Estudiante estudiante = new Estudiante();
        estudiante.setEstudianteId(estudianteId);
        estudianteRepository.delete(estudiante);
    }
    
}

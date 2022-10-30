package com.utp.edu.services.Impl;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.edu.models.Profesor;
import com.utp.edu.repositorys.ProfesorRepository;
import com.utp.edu.services.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository; 

    @Override
    public Profesor agregarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Set<Profesor> obtenerProfesores() {
        return new LinkedHashSet<>(profesorRepository.findAll());
    }

    @Override
    public Profesor obteneProfesor(Long profesorId) {
        return profesorRepository.findById(profesorId).get();
    }

    @Override
    public void eliminarProfesor(Long profesorId) {
        Profesor profesor = new Profesor();
        profesor.setProfesorId(profesorId);
        profesorRepository.delete(profesor);
    }
}

package com.utp.edu.services.Impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.edu.models.Sede;
import com.utp.edu.repositorys.SedeRepository;
import com.utp.edu.services.SedeService;

@Service
public class SedeServiceImpl implements SedeService{

    @Autowired
    private SedeRepository sedeRepository;

    @Override
    public Sede agregarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public Sede actualizarSede(Sede sede) {
        return sedeRepository.save(sede);
    }

    @Override
    public Set<Sede> obtenerSedes() {
        return new LinkedHashSet<>(sedeRepository.findAll());
    }

    @Override
    public Sede obtenerSede(Long sedeId) {
        return sedeRepository.findById(sedeId).get();
    }

    @Override
    public void eliminarSede(Long sedeId) {
        Sede sede = new Sede();
        sede.setSedeId(sedeId);
        sedeRepository.delete(sede);
    }
    
}

package com.utp.edu.services.Impl;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.edu.models.Turno;
import com.utp.edu.repositorys.TurnoRepository;
import com.utp.edu.services.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService{
    
    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public Turno agregarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Set<Turno> obtenerTurnos() {
        return new LinkedHashSet<>(turnoRepository.findAll());
    }

    @Override
    public Turno obteneTurno(Long turnoId) {
        return turnoRepository.findById(turnoId).get();
    }

    @Override
    public void eliminarTurno(Long turnoId) {
        Turno turno = new Turno();
        turno.setTurnoId(turnoId);
        turnoRepository.delete(turno);
    }
}

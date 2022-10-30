package com.utp.edu.services.Impl;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.edu.models.CursoVenta;
import com.utp.edu.repositorys.CursoVentaRepository;
import com.utp.edu.services.CursoVentaService;

@Service
public class CursoVentaServiceImpl implements CursoVentaService{

    @Autowired
    private CursoVentaRepository cursoVentaRepository; 

    @Override
    public CursoVenta agregaCursoVenta(CursoVenta cursoVenta) {
        return cursoVentaRepository.save(cursoVenta);
    }

    @Override
    public CursoVenta actualizaCursoVenta(CursoVenta cursoVenta) {
        return cursoVentaRepository.save(cursoVenta);
    }

    @Override
    public Set<CursoVenta> obtenerCursosVenta() {
        return new LinkedHashSet<>(cursoVentaRepository.findAll());
    }

    @Override
    public CursoVenta obtenerCursoVenta(Long cursoVentaId) {
        return cursoVentaRepository.findById(cursoVentaId).get();
    }

    @Override
    public void eliminarCursoVenta(Long cursoVentaId) {
        CursoVenta cursoVenta = new CursoVenta();
        cursoVenta.setId(cursoVentaId);
        cursoVentaRepository.delete(cursoVenta);
    }
}

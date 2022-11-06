package com.utp.edu.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.edu.models.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
    
}

package com.utp.edu.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.edu.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}

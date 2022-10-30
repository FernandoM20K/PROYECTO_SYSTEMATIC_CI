package com.utp.edu.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.edu.models.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
    
}

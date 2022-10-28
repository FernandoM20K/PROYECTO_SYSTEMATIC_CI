package com.utp.edu.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utp.edu.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
}

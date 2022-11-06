package com.utp.edu.repositorys;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.edu.models.Categoria;
import com.utp.edu.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

    Set<Producto> findByCategoria(Categoria categoria);
    
}

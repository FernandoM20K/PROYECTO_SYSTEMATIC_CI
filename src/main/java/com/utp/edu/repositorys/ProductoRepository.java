package com.utp.edu.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.edu.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}

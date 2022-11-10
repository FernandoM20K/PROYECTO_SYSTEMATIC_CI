package com.utp.edu.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.edu.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Optional<Usuario> findOneByEmail(String email);

}

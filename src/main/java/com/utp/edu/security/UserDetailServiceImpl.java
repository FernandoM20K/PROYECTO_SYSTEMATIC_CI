package com.utp.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utp.edu.models.Usuario;
import com.utp.edu.repositorys.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
            .findOneByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("El Usuario con Email " + email + "No Existe"));
    
        return new UserDetailsImpl(usuario);    
    }
}

package com.utp.edu.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    private Rol rol;

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

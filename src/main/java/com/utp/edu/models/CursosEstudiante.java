package com.utp.edu.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.PrePersist;

@Entity
@Table(name = "tb_cursos_estudiante")
public class CursosEstudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_venta_id")
    @JsonIgnore
    private CursoVenta cursoVenta;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @PrePersist
    public void PrePersist() {
        this.fechaCompra = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CursoVenta getCursoVenta() {
        return cursoVenta;
    }

    public void setCursoVenta(CursoVenta cursoVenta) {
        this.cursoVenta = cursoVenta;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    
}

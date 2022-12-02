package com.utp.edu.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //TODO: Define que es una entidad
@Table(name = "tb_profesores") //TODO: Nombre de la tabla
public class Profesor {

    @Id //TODO: Define que va a ser la primary Key de la Tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY) //TODO: Autoincrementable
    private Long profesorId;

    private String nombre;

    private String apellido;

    private String dni;

    private String celular;

    private String direccion;

    private String email;

    private double sueldo;

    private boolean estado;

    @ManyToOne(fetch = FetchType.EAGER) //TODO: Muchos  A Uno
    @JoinColumn(name = "sedeId")
    private Sede sede;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profesor")
    @JsonIgnore
    private List<CursoVenta> cursoVentas;

    public Profesor() {
    
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<CursoVenta> getCursoVentas() {
        return cursoVentas;
    }

    public void setCursoVentas(List<CursoVenta> cursoVentas) {
        this.cursoVentas = cursoVentas;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

}

package com.utp.edu.services;

import java.util.Set;

import com.utp.edu.models.Categoria;

public interface CategoriaService {
    Categoria agregarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria);
    Set<Categoria> obtenerCategorias();
    Categoria obteneCategoria(Long categoriaId);
    void eliminarCategoria(Long categoriaId);
}

package com.utp.edu.services;

import com.utp.edu.models.Producto;

public interface ProductoService {
    Producto agregarProducto(Producto producto);
    Producto actualiProducto(Producto producto);
    Producto obtenerProducto(Long productoId);
    void eliminarProducto(Long productoId);
}

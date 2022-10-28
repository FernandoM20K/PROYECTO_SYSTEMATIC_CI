package com.utp.edu.services;

import java.util.Set;
import com.utp.edu.models.Producto;

public interface ProductoService {
    Producto agregarProducto(Producto producto);
    Producto actualiProducto(Producto producto);
    Set<Producto> obtenerProductos();
    Producto obtenerProducto(Long productoId);
    void eliminarProducto(Long productoId);
}

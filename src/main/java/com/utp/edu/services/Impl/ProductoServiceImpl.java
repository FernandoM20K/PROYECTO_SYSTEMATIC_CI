package com.utp.edu.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.utp.edu.models.Producto;
import com.utp.edu.repositorys.ProductoRepository;
import com.utp.edu.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualiProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto obtenerProducto(Long productoId) {
        return productoRepository.findById(productoId).get();
    }

    @Override
    public void eliminarProducto(Long productoId) {
        Producto producto = new Producto();
        producto.setProductoId(productoId);
        productoRepository.delete(producto);
    }
}

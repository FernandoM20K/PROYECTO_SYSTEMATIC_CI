package com.utp.edu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.utp.edu.models.Producto;
import com.utp.edu.services.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    @PostMapping("/")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.agregarProducto(producto));
    }

    @PutMapping("/")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.actualiProducto(producto));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarProductos() {
        return ResponseEntity.ok(productoService.obtenerProductos());
    }

    @GetMapping("/{productoId}")
    public Producto listarProducto(@PathVariable("productoId") Long productoId) {
        return productoService.obtenerProducto(productoId);
    }

    @DeleteMapping("/{productoId}")
    public void eliminarProducto(@PathVariable("productoId") Long productoId) {
        productoService.eliminarProducto(productoId);
    }
}

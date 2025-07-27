package com.proyectofinal.bazar.controller;

import com.proyectofinal.bazar.model.Producto;
import com.proyectofinal.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @PostMapping("/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
        return "Producto creado correctamente";
    }

    @GetMapping
    public List<Producto> obtenerProductos(){
        return productoService.obtenerTodosLosProductos();
    }

    @GetMapping("/{codigo}")
    public Producto obtenerProducto(@PathVariable Long codigo){
        return productoService.buscarProducto(codigo);
    }

    @DeleteMapping("/{codigo}")
    public String borrarProducto(@PathVariable Long codigo){
        productoService.borrarProducto(codigo);
        return "Producto borrado correctamente";
    }

    @PutMapping("/editar")
    public String editarProducto(@RequestBody Producto producto){
        productoService.editarProducto(producto);
        return "Producto editado correctamente";
    }

    @GetMapping("/falta_stock")
    public List<Producto> obtenerProductosPocoStock(){
        return productoService.obtenerProductosFaltaStock();
    }


}

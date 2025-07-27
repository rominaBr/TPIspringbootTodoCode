package com.proyectofinal.bazar.service;

import com.proyectofinal.bazar.model.Producto;
import com.proyectofinal.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void editarProducto(Producto producto) {
        this.guardarProducto(producto);
    }

    @Override
    public void borrarProducto(Long codigo) {
        productoRepository.deleteById(codigo);
    }

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto buscarProducto(Long codigo) {
        return productoRepository.findById(codigo).orElseThrow(()->new RuntimeException("Producto no encontrado."));
    }


    @Override
    public List<Producto> obtenerProductosFaltaStock() {
        List<Producto> productos = this.obtenerTodosLosProductos();
        List<Producto> productosFaltaStock = new ArrayList<>();
        for(Producto producto: productos){
            if(producto.getCantidadDisponible()<5){
                productosFaltaStock.add(producto);
            }
        }
        return productosFaltaStock;
    }

}

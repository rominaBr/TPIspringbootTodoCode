package com.proyectofinal.bazar.service;

import com.proyectofinal.bazar.model.Producto;
import java.util.List;

public interface IProductoService {

    void guardarProducto(Producto producto);
    void editarProducto(Producto producto);
    void borrarProducto(Long codigo);
    List<Producto> obtenerTodosLosProductos();
    Producto buscarProducto(Long codigo);
    List<Producto> obtenerProductosFaltaStock();
}

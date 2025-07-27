package com.proyectofinal.bazar.service;

import com.proyectofinal.bazar.dto.TotalesDto;
import com.proyectofinal.bazar.dto.VentaClienteProductoDto;
import com.proyectofinal.bazar.model.Producto;
import com.proyectofinal.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    void guardarVenta(Venta venta);
    List<Venta> obtenerToasLasVentas();
    Venta buscarVenta(Long codigo);
    void borrarVenta(Long codigo);
    void editarVenta(Venta venta);
    TotalesDto totalesVentasPorFecha(LocalDate fechaVenta);
    VentaClienteProductoDto traerMayorVenta();
    List<Producto> obtenerProductosPorVenta(Long codVenta);

}

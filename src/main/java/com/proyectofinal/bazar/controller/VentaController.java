package com.proyectofinal.bazar.controller;

import com.proyectofinal.bazar.dto.TotalesDto;
import com.proyectofinal.bazar.dto.VentaClienteProductoDto;
import com.proyectofinal.bazar.model.Producto;
import com.proyectofinal.bazar.model.Venta;
import com.proyectofinal.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;


    @PostMapping("/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaService.guardarVenta(venta);
        return "Venta creada correctamente";
    }

    @GetMapping
    public List<Venta> obtenerTodasLasVentas(){
        return ventaService.obtenerToasLasVentas();
    }

    @GetMapping("/{codigo}")
    public Venta obtenerVentaPorCodigo(@PathVariable Long codigo){
        return ventaService.buscarVenta(codigo);
    }

    @DeleteMapping("/{codigo}")
    public String borrarVenta(@PathVariable Long codigo){
        ventaService.borrarVenta(codigo);
        return "Venta borrada correctamente";
    }

    @PutMapping("/editar")
    public String editarVenta(@RequestBody Venta venta){
        ventaService.editarVenta(venta);
        return "Venta editada correctamente";
    }

    @GetMapping("/productos/{codigo}")
    public List<Producto> trerProductosPorVenta(@PathVariable Long codigo){
        return ventaService.obtenerProductosPorVenta(codigo);
    }

    @GetMapping("/mayor_venta")
    public VentaClienteProductoDto obtenerMayorVenta(){
        return ventaService.traerMayorVenta();
    }

    @GetMapping("/fecha/{fecha_venta}")
    public TotalesDto obtenerTotalesPorFecha(@PathVariable LocalDate fecha_venta){
        return ventaService.totalesVentasPorFecha(fecha_venta);
    }



}

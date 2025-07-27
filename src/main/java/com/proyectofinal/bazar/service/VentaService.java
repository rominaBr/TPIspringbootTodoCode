package com.proyectofinal.bazar.service;

import com.proyectofinal.bazar.dto.TotalesDto;
import com.proyectofinal.bazar.dto.VentaClienteProductoDto;
import com.proyectofinal.bazar.model.Producto;
import com.proyectofinal.bazar.model.Venta;
import com.proyectofinal.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public void guardarVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public List<Venta> obtenerToasLasVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta buscarVenta(Long codigo) {
        return ventaRepository.findById(codigo).orElseThrow(()-> new RuntimeException("Venta no encontrada."));
    }

    @Override
    public void borrarVenta(Long codigo) {
        ventaRepository.deleteById(codigo);
    }

    @Override
    public void editarVenta(Venta venta) {
        this.guardarVenta(venta);
    }

    @Override
    public TotalesDto totalesVentasPorFecha(LocalDate fechaVenta) {
        List<Venta> ventasPorFecha = ventaRepository.findAllByFechaVenta(fechaVenta);
        TotalesDto totalesDto = new TotalesDto();
        for(Venta venta : ventasPorFecha){
            totalesDto.setMontoSumatoria(totalesDto.getMontoSumatoria() + venta.getTotal());
            totalesDto.setCantidadTotal(totalesDto.getCantidadTotal() + 1);
        }
        return totalesDto;
    }

    @Override
    public VentaClienteProductoDto traerMayorVenta() {
        Double montoMayorVenta = 0.0;
        List<Venta> ventas = this.obtenerToasLasVentas();
        Long codigoVentaMayorMonto;
        Venta ventaMayorMonto = new Venta();
        VentaClienteProductoDto ventaClienteProductoDto = new VentaClienteProductoDto();

        for(Venta venta: ventas){
            if(venta.getTotal() > montoMayorVenta){
                montoMayorVenta = venta.getTotal();
                codigoVentaMayorMonto = venta.getCodigo();
                ventaMayorMonto = ventaRepository.findById(codigoVentaMayorMonto).orElseThrow(()->new RuntimeException("No existe venta."));
            }
        }

        ventaClienteProductoDto.setCodigoVenta(ventaMayorMonto.getCodigo());
        ventaClienteProductoDto.setApellidoCliente(ventaMayorMonto.getCliente().getApellido());
        ventaClienteProductoDto.setNombreCliente(ventaMayorMonto.getCliente().getNombre());
        ventaClienteProductoDto.setTotal(montoMayorVenta);
        ventaClienteProductoDto.setCantidadProductos(ventaMayorMonto.getListaProductos().size());

        return ventaClienteProductoDto;
    }

    @Override
    public List<Producto> obtenerProductosPorVenta(Long codVenta) {
        Venta venta = ventaRepository.findById(codVenta).orElseThrow(()->new RuntimeException("No existe venta."));

        return venta.getListaProductos();

    }
}

package com.proyectofinal.bazar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaClienteProductoDto {

    private Long codigoVenta;
    private Double total;
    private Integer cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

}

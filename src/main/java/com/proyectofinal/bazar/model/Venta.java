package com.proyectofinal.bazar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private LocalDate fechaVenta;
    private Double total;
    @ManyToMany
    private List<Producto> listaProductos;
    @ManyToOne
    private Cliente cliente;

}

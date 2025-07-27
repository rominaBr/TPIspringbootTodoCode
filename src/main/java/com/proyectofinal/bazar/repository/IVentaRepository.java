package com.proyectofinal.bazar.repository;

import com.proyectofinal.bazar.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {

    List<Venta> findAllByFechaVenta(LocalDate fechaVenta);

}

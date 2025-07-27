package com.proyectofinal.bazar.repository;

import com.proyectofinal.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}

package com.proyectofinal.bazar.repository;

import com.proyectofinal.bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}

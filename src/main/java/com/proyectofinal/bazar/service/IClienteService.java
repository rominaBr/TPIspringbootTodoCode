package com.proyectofinal.bazar.service;

import com.proyectofinal.bazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    void guardarCliente(Cliente cliente);
    List<Cliente> obtenerTodosLosClientes();
    Cliente buscarCliente(Long id);
    void borrarCliente(Long id);
    void editarCliente(Cliente cliente);


}

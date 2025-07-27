package com.proyectofinal.bazar.service;

import com.proyectofinal.bazar.model.Cliente;
import com.proyectofinal.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id).orElseThrow(()-> new RuntimeException("El cliente no existe."));
    }

    @Override
    public void borrarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        this.guardarCliente(cliente);
    }
}

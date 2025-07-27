package com.proyectofinal.bazar.controller;

import com.proyectofinal.bazar.model.Cliente;
import com.proyectofinal.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @PostMapping("/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteService.guardarCliente(cliente);
        return "Cliente creado correctamente";
    }

    @GetMapping
    public List<Cliente> traerTodosLOsClientes(){
        return clienteService.obtenerTodosLosClientes();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id){
        return clienteService.buscarCliente(id);
    }

    @DeleteMapping("/{id}")
    public String borrarCliente(@PathVariable Long id){
        clienteService.borrarCliente(id);
        return "Cliente borrado correctamente";
    }

    @PutMapping("/editar")
    public String editarCliente(@RequestBody Cliente cliente){
        clienteService.editarCliente(cliente);
        return "Cliente editado correctamente.";
    }


}

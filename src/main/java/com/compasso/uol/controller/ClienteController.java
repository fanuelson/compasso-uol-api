package com.compasso.uol.controller;

import com.compasso.uol.model.Cliente;
import com.compasso.uol.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

}

package com.compasso.uol.service;

import com.compasso.uol.model.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente criar(Cliente cliente);

    List<Cliente> find(String nome);

    Cliente findById(Long id);

}

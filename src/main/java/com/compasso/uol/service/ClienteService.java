package com.compasso.uol.service;

import com.compasso.uol.dtos.ClienteChangeNameRequest;
import com.compasso.uol.model.Cliente;

import javax.validation.Valid;
import java.util.List;

public interface ClienteService {

    Cliente criar(@Valid Cliente cliente);

    List<Cliente> find(String nome);

    Cliente findById(Long id);

    boolean delete(Long id);

    Cliente updateNomeCompleto(Long id, @Valid ClienteChangeNameRequest clienteChangeNameRequest);

}

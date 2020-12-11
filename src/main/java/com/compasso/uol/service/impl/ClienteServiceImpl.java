package com.compasso.uol.service.impl;

import com.compasso.uol.dao.ClienteDAO;
import com.compasso.uol.model.Cliente;
import com.compasso.uol.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteDAO clienteDAO;

    @Autowired
    public ClienteServiceImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        Long idCriado = clienteDAO.criar(cliente);
        cliente.setId(idCriado);
        return cliente;
    }

    @Override
    public List<Cliente> find(String nome) {
        return clienteDAO.find(nome);
    }
}

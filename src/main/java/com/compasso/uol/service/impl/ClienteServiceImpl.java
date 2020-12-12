package com.compasso.uol.service.impl;

import com.compasso.uol.dao.ClienteDAO;
import com.compasso.uol.dtos.ClienteChangeNameRequest;
import com.compasso.uol.exceptions.ApiException;
import com.compasso.uol.model.Cliente;
import com.compasso.uol.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class ClienteServiceImpl implements ClienteService {

    private final ClienteDAO clienteDAO;

    @Autowired
    public ClienteServiceImpl(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public Cliente criar(@Valid Cliente cliente) {
        Long idCriado = clienteDAO.criar(cliente);
        cliente.setId(idCriado);
        return cliente;
    }

    @Override
    public List<Cliente> find(String nome) {
        return clienteDAO.find(nome);
    }

    public Cliente findById(Long id) {
        return clienteDAO.findById(id)
                .orElseThrow(() -> new ApiException("Cliente não encontrado", HttpStatus.NOT_FOUND));
    }

    @Override
    public boolean delete(Long id) {
        boolean deleted = clienteDAO.delete(id);
        if (deleted) {
            return true;
        }
        throw new ApiException("Cliente não encontrado", HttpStatus.NOT_FOUND);
    }

    @Override
    public Cliente updateNomeCompleto(Long id, @Valid ClienteChangeNameRequest clienteChangeNameRequest) {
        Cliente cliente = findById(id);
        cliente.setNomeCompleto(clienteChangeNameRequest.getNomeCompleto());
        clienteDAO.updateCliente(cliente.getId(), cliente);
        return cliente;
    }
}

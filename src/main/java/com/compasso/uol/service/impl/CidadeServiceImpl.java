package com.compasso.uol.service.impl;

import com.compasso.uol.dao.CidadeDAO;
import com.compasso.uol.dtos.CidadeFiltroDTO;
import com.compasso.uol.model.Cidade;
import com.compasso.uol.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    private final CidadeDAO cidadeDAO;

    @Autowired
    public CidadeServiceImpl(CidadeDAO cidadeDAO) {
        this.cidadeDAO = cidadeDAO;
    }

    public Cidade criar(Cidade cidade) {
        Long idCriado = cidadeDAO.criar(cidade);
        cidade.setId(idCriado);
        return cidade;
    }

    public List<Cidade> find(CidadeFiltroDTO cidadeFiltroDTO) {
        return cidadeDAO.find(cidadeFiltroDTO);
    }

    public Cidade findById(Long id) {
        return cidadeDAO.findById(id)
                .orElse(null);
    }
}

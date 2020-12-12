package com.compasso.uol.service;

import com.compasso.uol.dtos.CidadeFiltroDTO;
import com.compasso.uol.model.Cidade;

import java.util.List;

public interface CidadeService {

    Cidade criar(Cidade cidade);

    List<Cidade> find(CidadeFiltroDTO cidadeFiltroDTO);

    Cidade findById(Long id);
}

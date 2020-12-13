package com.compasso.uol.controller;

import com.compasso.uol.dtos.CidadeFiltroDTO;
import com.compasso.uol.model.Cidade;
import com.compasso.uol.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Cidade create(@RequestBody Cidade cidade) {
        return cidadeService.criar(cidade);
    }

    @GetMapping
    public List<Cidade> find(CidadeFiltroDTO cidadeFiltroDTO) {
        return cidadeService.find(cidadeFiltroDTO);
    }
}

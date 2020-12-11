package com.compasso.uol.controller;

import com.compasso.uol.model.Cidade;
import com.compasso.uol.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Cidade criar(@RequestBody Cidade cidade) {
        return cidadeService.criar(cidade);
    }

}

package com.compasso.uol.model;

import com.compasso.uol.enums.EstadoEnum;

public class Cidade {

    private Long id;

    private String nome;

    private EstadoEnum estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }
}

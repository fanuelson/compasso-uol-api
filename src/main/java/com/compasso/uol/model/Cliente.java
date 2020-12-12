package com.compasso.uol.model;

import com.compasso.uol.enums.SexoEnum;
import com.compasso.uol.validators.annotations.CityMustExists;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Cliente {

    private Long id;

    private String nomeCompleto;

    private SexoEnum sexo;

    private LocalDate dataNascimento;

    private int idade;

    private Cidade cidade;

    @NotNull(message = "{cliente.cidade.required}")
    @CityMustExists
    private Long cidadeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }
}

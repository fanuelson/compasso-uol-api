package com.compasso.uol.enums;

public enum SexoEnum {

    MASCULINO("Masculino", 'M'),
    FEMININO("Feminino", 'F'),
    INDEFINIDO("Indefinido", 'I');

    private final String nome;
    private final Character sigla;

    SexoEnum(String nome, Character sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public Character getSigla() {
        return sigla;
    }
}

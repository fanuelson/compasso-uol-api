package com.compasso.uol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteChangeNameRequest {

    @NotBlank(message = "{cliente.nome.completo.vazio}")
    @Size(max = 255, message = "{cliente.nome.completo.tamanho}")
    private String nomeCompleto;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}

package br.com.clara.orcamento.dto;

import java.math.BigDecimal;

public class MunicipioDto {

        private Long id;
        private String nome;

        private String Estado;

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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}

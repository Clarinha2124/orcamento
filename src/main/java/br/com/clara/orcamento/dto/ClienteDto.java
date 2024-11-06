package br.com.clara.orcamento.dto;

import br.com.clara.orcamento.model.Cliente;

import java.math.BigDecimal;

public class ClienteDto {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;
    private String endereco;

    public ClienteDto(String nome, String endereco, String numero) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
    }

    private String numero;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    private String bairro;

    private String telefone;
    private String celular;

    public ClienteDto(String endereco,String numero) {
        this.numero = numero;
        this.endereco = endereco;

    }
}

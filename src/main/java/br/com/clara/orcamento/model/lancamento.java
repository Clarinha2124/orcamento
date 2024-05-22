package br.com.clara.orcamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="lancamento")

public class lancamento {
    @Id
    private Long id;
    private LocalDate datalancamento;
    private Long idcliente;
    private String tipolancamento;
    private BigDecimal valorlancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        lancamento that = (lancamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public LocalDate getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.datalancamento = datalancamento;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getTipolancamento() {
        return tipolancamento;
    }

    public void setTipolancamento(String tipolancamento) {
        this.tipolancamento = tipolancamento;
    }

    public BigDecimal getValorlancamento() {
        return valorlancamento;
    }

    public void setValorlancamento(BigDecimal valorlancamento) {
        this.valorlancamento = valorlancamento;
    }
}

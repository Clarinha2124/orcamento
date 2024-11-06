package br.com.clara.orcamento.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoDto {
    private Long id;

    public Long getId() {
        return id;
    }

    public LancamentoDto(Long id, LocalDate datalancamento, String tipolancamento, BigDecimal valorlancamento) {
        this.id = id;
        this.datalancamento = datalancamento;
        this.tipolancamento = tipolancamento;
        this.valorlancamento = valorlancamento;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatalancamento() {
        return datalancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.datalancamento = datalancamento;
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

    private LocalDate datalancamento;

    private String tipolancamento;
    private BigDecimal valorlancamento;
}

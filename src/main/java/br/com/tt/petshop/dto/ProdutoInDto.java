package br.com.tt.petshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoInDto {

    private BigDecimal valor;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate criacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate alteracao;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getCriacao() {
        return criacao;
    }

    public void setCriacao(LocalDate criacao) {
        this.criacao = criacao;
    }

    public LocalDate getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(LocalDate alteracao) {
        this.alteracao = alteracao;
    }
}

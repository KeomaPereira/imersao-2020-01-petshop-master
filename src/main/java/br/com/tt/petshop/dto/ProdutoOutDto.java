package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoOutDto {

    private long id;

    private BigDecimal valor;

    private String descricao;

    private LocalDate criacao;

    private LocalDate alteracao;

    public ProdutoOutDto(Produto a) {
        id = a.getId();
        valor = a.getValor();
        descricao = a.getDescricao();
        criacao = a.getCriacao();
        alteracao = a.getAlteracao();
    }

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

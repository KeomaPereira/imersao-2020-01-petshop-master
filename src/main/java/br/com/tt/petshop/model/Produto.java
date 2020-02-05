package br.com.tt.petshop.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    //Outros- com tabela de controle do HIBERNATE
    //    @GeneratedValue(strategy = GenerationType.TABLE)
    //Oracle - Sequence
    //    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_gen")
    //    @SequenceGenerator(name = "sq_gen", sequenceName = "SEQUENCE_PRODUTO")
    //Mysql - com auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "criacao", updatable = false)
    @CreatedDate
    private LocalDate criacao;

    @Column(name = "alteracao")
    @LastModifiedDate
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

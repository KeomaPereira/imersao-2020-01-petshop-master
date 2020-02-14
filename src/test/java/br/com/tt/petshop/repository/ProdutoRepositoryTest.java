package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@ActiveProfiles("testes")
@Sql(value = "classpath:/popula_produtos.sql",
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)

@Sql(value = "classpath:/limpa_produtos.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void findAllByValorGreaterThan() {

        BigDecimal valor = BigDecimal.valueOf(50);
        produtoRepository.findAllByValorGreaterThan(valor);

        List<Produto> resultado = produtoRepository.findAllByValorGreaterThan(valor);

        Assertions.assertEquals(1,resultado.size());

    }
}
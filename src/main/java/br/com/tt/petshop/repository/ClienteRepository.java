package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepository {
//    private List<Cliente> db = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;

    public ClienteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Cliente save(Cliente cliente){
//        db.add(cliente);

        final String sql = "insert into TB_CLIENTE (nome, cpf, nascimento) values (?, ?, ?)";
        jdbcTemplate.update(sql,
                cliente.getNome(), cliente.getCpf(),
                cliente.getNascimento());
        return cliente;
    }

    public List<Cliente> findAll(){

        return jdbcTemplate.query("select id, nome, cpf, nascimento from TB_CLIENTE",
                new ClienteRowMapper());
//        return db;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from cliente where id = ?", id);
    }
}

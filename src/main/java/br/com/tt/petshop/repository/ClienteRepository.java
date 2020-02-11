package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ClienteRepository {
//    private List<Cliente> db = new ArrayList<>();
    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;


    public ClienteRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public Cliente saveJdbc(Cliente cliente){
//        db.add(cliente);
        final String sql = "insert into TB_CLIENTE (nome, cpf, nascimento) values (?, ?, ?)";
        jdbcTemplate.update(sql,
                cliente.getNome(), cliente.getCpf(),
                cliente.getNascimento());
        return cliente;
    }

    @Transactional
    @Modifying
    public Cliente save(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    public List<Cliente> findAll(){
        return entityManager
                .createQuery("from Cliente")
                .getResultList();
//        return jdbcTemplate.query("select id, nome, cpf, nascimento from TB_CLIENTE",
//                new ClienteRowMapper());
//        return db;
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("delete from TB_CLIENTE where id = ?", id);
    }
}

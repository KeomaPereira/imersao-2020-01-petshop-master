package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UnidadeRepository {

    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public UnidadeRepository(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    public Unidade criar(Unidade unidade){
        entityManager.persist(unidade);
        return unidade;
    }

    public Unidade update(Unidade unidade){
        Unidade unidadeSalva = entityManager.merge(unidade);
        return unidadeSalva;
    }

//    private List<Unidade> db = new ArrayList<>();

    public Unidade save(Unidade unidade) {
//        db.add(unidade);

        jdbcTemplate
            .update("insert into TB_UNIDADE (nome, endereco) values (?,?)",
                        unidade.getNome(), unidade.getEndereco());
        return unidade;
    }

    public List<Unidade> findAll() {
        //Aqui cria-se uma nova lista que não pode ser modificada;
//        return Collections.unmodifiableList(db);
        return jdbcTemplate
            .query("select nome, endereco from TB_UNIDADE",
                    new UnidadeRowMapper());
    }

    public void delete(String nome) {
//        List<Unidade> listaAposExclusao = new ArrayList<>();
//
//        Iterator<Unidade> iterator = db.iterator();
//        while (iterator.hasNext()){
//            Unidade unidade = iterator.next();
//            if(!unidade.getNome().equalsIgnoreCase(nome)){
//                listaAposExclusao.add(unidade);
//            }
//        }
//        db = listaAposExclusao;

        jdbcTemplate
            .update("delete from TB_UNIDADE Where nome = ?",
            nome);
    }

    public Unidade findById(Long id) {
        return (Unidade) entityManager
                .createQuery("from TB_UNIDADE u where u.id = :id ")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Modifying
    @Transactional
    public void deleteById(long id) {
        entityManager.createQuery("delete from Unidade where id = :id" )
                .setParameter("id", id)
                .executeUpdate();
    }

}

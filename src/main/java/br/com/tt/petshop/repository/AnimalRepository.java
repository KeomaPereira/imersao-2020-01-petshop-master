package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AnimalRepository
        extends JpaRepository<Animal, Long> {


    List<Animal> findById(BigDecimal id);

}

package br.com.tt.petshop.service;

import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }

    public List<Animal> listar(){
        return this.animalRepository.findAll();
    }

    public Optional<Animal> findById(Long id) {
        return animalRepository.findById(id);
    }

    public List<Animal> buscarTodos(){
        return this.animalRepository.findAll();
    }
}

package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.AnimalOutDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.service.AnimalService;
import br.com.tt.petshop.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animais")
public class AnimalEndpoint {

    private AnimalService animalService;

    public AnimalEndpoint(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity criar(@RequestBody Animal animal) {
        Animal animalSalvo = animalService.salvar(animal);

        return ResponseEntity
                .created(URI.create("/animais/" + animalSalvo.getId()))
                .build();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AnimalOutDto> buscarPorId(@PathVariable Long id){
        Optional<Animal> animalOpt = animalService.findById(id);
        AnimalOutDto dto = animalOpt
                .map(a -> new AnimalOutDto(a))
                .orElseThrow(
                        () -> new IllegalArgumentException("Animal não existe")
                );
            return ResponseEntity.ok(dto);
        }

   @GetMapping("/animais/")
   public ResponseEntity<List<Animal>> buscarTodos(){
        List<Animal> listaAnimais = animalService.listar();

       for (Animal animal: listaAnimais) {
           new AnimalOutDto(animal);
       }
       return null;
   }



}

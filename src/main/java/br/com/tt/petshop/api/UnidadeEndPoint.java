package br.com.tt.petshop.api;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController

class UnidadeEndpoint {
    private UnidadeService unidadeService;

    public UnidadeEndpoint(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping("/unidades")
    public List<Unidade> buscarTodos(){
        return unidadeService.listar();
    }

    @GetMapping("/unidades/{id}")
    public Unidade buscaPorId(@PathVariable Long id){
        return unidadeService.buscarPorId(id);
    }

    @PostMapping("/unidades")
    public void criar(@RequestBody Unidade unidade){
        unidadeService.salvar(unidade);
    }


    @DeleteMapping("/unidades/{id}")
    public void deletar(@PathVariable Long id){
       unidadeService.deletarPorId(id);
    }
}
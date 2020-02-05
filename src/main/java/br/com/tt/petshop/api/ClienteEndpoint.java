package br.com.tt.petshop.api;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.ClienteService;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

class ClienteEndpoint {
    private ClienteService clienteService;

    public ClienteEndpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> buscarTodos(){
        return clienteService.listar();
    }



//    @GetMapping("/clientes/{id}")
//    public Cliente buscaPorId(@PathVariable Long id){
//        return clienteService.buscarPorId(id);
//    }

    @PostMapping("/clientes")
    public void criar(@RequestBody Cliente cliente){
        clienteService.criar(cliente);
    }


//    @DeleteMapping("/clientes/{id}")
//    public void deletar(@PathVariable Long id){
//        clienteService.deletarPorId(id);
//    }


}
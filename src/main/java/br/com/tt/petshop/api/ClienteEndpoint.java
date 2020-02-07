package br.com.tt.petshop.api;
import br.com.tt.petshop.api.exception.ClienteException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.ClienteService;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController

class ClienteEndpoint {
    private ClienteService clienteService;

    public ClienteEndpoint(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> buscarTodos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-SITUACAO", "Ativos")
                .body(clienteService.listar());
    }




//    @GetMapping("/clientes/{id}")
//    public Cliente buscaPorId(@PathVariable Long id){
//        return clienteService.buscarPorId(id);
//    }

    @PostMapping("/clientes")
    public ResponseEntity criar(@RequestBody Cliente cliente) throws ClienteException {
        Cliente clienteSalvo = null;

            clienteSalvo = clienteService.criar(cliente);



        URI uri = URI.create("/clientes/"+ clienteSalvo.getId());
        //clienteService.criar(cliente);
        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping("/clientes/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }


}
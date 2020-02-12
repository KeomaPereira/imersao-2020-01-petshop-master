package br.com.tt.petshop.api;

import br.com.tt.petshop.dto.ProdutoInDto;
import br.com.tt.petshop.dto.ProdutoOutDto;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Produto;
import br.com.tt.petshop.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoEndpoint {

    private ProdutoService produtoService;
    private ModelMapper modelMapper;

    public ProdutoEndpoint(ProdutoService produtoService, ModelMapper modelMapper) {
        this.produtoService = produtoService;
        this.modelMapper = modelMapper;
    }

//    @PostMapping
//    public ResponseEntity criar(@RequestBody Produto produto) {
//        Produto produtoSalvo = produtoService.salvar(produto);
//
//        return ResponseEntity
//                .created(URI.create("/produtos/" + produtoSalvo.getId()))
//                .build();
//    }

    @PostMapping
    public ResponseEntity criar(@RequestBody @Valid ProdutoInDto produtoDto) {

        Produto produto = modelMapper.map(produtoDto, Produto.class);

        Produto produtoSalvo = produtoService.salvar(produto);

        return ResponseEntity
                .created(URI.create("/produtos/" + produtoSalvo.getId()))
                .build();
    }


//    @GetMapping()
//    public ResponseEntity<List<Produto>> procurarPorValor(@RequestParam (required = false) BigDecimal valorMaiorQue){
//        List<Produto> produtos = produtoService.findByValor(valorMaiorQue);
//        return ResponseEntity.created(URI.create("/produtos/"))
//                .body(produtos);
//    }

    @GetMapping
    public ResponseEntity  <List<ProdutoOutDto>>  findAll(){
        return ResponseEntity.ok(produtoService
                .listar().stream()
                .map(ProdutoOutDto::new)
                .collect(Collectors.toList()));
    }


}

package br.com.tt.petshop.service;

import br.com.tt.petshop.api.exception.ClienteException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteException clienteException;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente) throws ClienteException {
        if (cliente.getNome().length() < 11)
            throw new ClienteException("Nome pequeno");
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        return this.clienteRepository.findAll();
    }

    public void excluir(Long id) {
        this.clienteRepository.deleteById(id);
    }

    public void deletarPorId(Long id) {
        this.clienteRepository.deleteById(id);
    }
}

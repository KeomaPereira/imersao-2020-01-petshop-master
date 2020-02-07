package br.com.tt.petshop.service;

import br.com.tt.petshop.api.exception.ClienteException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public static final int INT = 11;
    private ClienteRepository clienteRepository;
    private ClienteException clienteException;
    private static final Logger LOG = LoggerFactory.getLogger(ClienteService.class);
    private static final int TAMANHO_MINIMO_NOME = 4;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente) throws ClienteException {
//        if (cliente.getNome().length() < 11) {
//            LOG.debug("Nome muito curto: {}", cliente.getNome());
//            throw new ClienteException("Nome pequeno");
//        }
        validarNomePequeno(cliente);
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

    public void validarNomePequeno (Cliente cliente) throws ClienteException {
        if (cliente.getNome().length() <= TAMANHO_MINIMO_NOME) {
            LOG.debug("Nome muito curto: {}", cliente.getNome());
            throw new ClienteException("Nome pequeno");
        }
    }

}

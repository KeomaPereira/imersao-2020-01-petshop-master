package br.com.tt.petshop.dto;

import br.com.tt.petshop.model.Animal;

import java.time.LocalDate;

public class AnimalOutDto {

    private long id;

    private String nome;

    private LocalDate nascimento;

    private String clienteNome;

    public long getId() {
        return id;
    }

    public AnimalOutDto (Animal a) {
        id = a.getId();
        nome = a.getNome();
        nascimento = a.getNascimento();
        clienteNome = a.getCliente().getNome();
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}

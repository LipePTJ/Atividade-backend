package com.biolab.catalogo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // <--- ESTA É A LINHA QUE FALTA!
    private Long id;
    private String nome;
    private String genero;
    private LocalDate dataLancamento;

    public Filme(Long id, String nome, String genero, LocalDate dataLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
    }

    public Filme(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}


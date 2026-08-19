package com.biolab.catalogo.DTOs;

import com.biolab.catalogo.Entities.Filme;

import java.time.LocalDate;

public class FilmeResponse {

    private Long id;
    private String nome;
    private String genero;
    private LocalDate dataLancamento;

    public FilmeResponse() {
    }

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

    public FilmeResponse(Long id, String nome, String genero, LocalDate dataLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.dataLancamento = dataLancamento;

    }
}

package com.biolab.catalogo.Services;

import com.biolab.catalogo.DTOs.FilmeRequest;
import com.biolab.catalogo.DTOs.FilmeResponse;
import com.biolab.catalogo.Entities.Filme;
import com.biolab.catalogo.Repositorys.FilmesRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmesRepository filmesRepository;

    public FilmeService(FilmesRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    // Cria o filme e gera a data de lançamento automaticamente com o dia de hoje antes de salvar
    public FilmeRequest criarFilme( FilmeRequest request) {
        Filme filme = new Filme();
        filme.setNome(request.getNome());
        filme.setGenero(request.getGenero());
        filme.setDataLancamento(LocalDate.now());

        filmesRepository.save(filme);
        return request;
    }
    public List<FilmeResponse> mostrarFilme() {
        return filmesRepository.findAll().stream().map(filme -> new FilmeResponse(filme.getId(), filme.getNome(),
                filme.getGenero(), filme.getDataLancamento())).toList();
    }
    // / Tenta achar o filme pelo ID
    public FilmeResponse buscarID(long id) {
        Optional<Filme> filme = filmesRepository.findById(id);

        if (filme.isPresent()) {
            FilmeResponse response = new FilmeResponse();
            response.setId(filme.get().getId());
            response.setNome(filme.get().getNome());
            response.setGenero(filme.get().getGenero());
            response.setDataLancamento(filme.get().getDataLancamento());
            return response;
        }
        return null;
    }

    // Verifica se o filme existe antes de tentar apagar
    public String deletar(long id) {
        Optional<Filme> filme = filmesRepository.findById(id);
        if (filme.isEmpty()) {
            return "Filme não existe";
        } else {
            filmesRepository.deleteById(id);
            return "Filme deletado com sucesso";
        }
    }

    // Busca o filme antigo e substitui o nome e o gênero pelos dados novos
    public String alterar(long id, FilmeRequest request) {

        Filme filme = filmesRepository.findById(id).orElseThrow();
        filme.setNome(request.getNome());
        filme.setGenero(request.getGenero());
        filmesRepository.save(filme);
        return "Filme atualizado com sucesso";
    }
}
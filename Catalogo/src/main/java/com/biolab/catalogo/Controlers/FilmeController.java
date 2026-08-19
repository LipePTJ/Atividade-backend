//Recebe as requisições relacionadas aos filmes

package com.biolab.catalogo.Controlers;

import com.biolab.catalogo.DTOs.FilmeRequest;
import com.biolab.catalogo.DTOs.FilmeResponse;
import com.biolab.catalogo.Services.FilmeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/filme")
public class FilmeController {


    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    // Recebe os dados via JSON e salva um novo filme
    @PostMapping
    public ResponseEntity<?> criarFilme(@Valid @RequestBody FilmeRequest req) {
        FilmeRequest criado = filmeService.criarFilme(req);
        return ResponseEntity.ok(criado);
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponse>> mostrar() {
        return ResponseEntity.ok(filmeService.mostrarFilme());
    }
    //Busca os detalhes de apenas um filme usando o seu número de ID
    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponse> buscarId(@PathVariable long id) {
        return ResponseEntity.ok(filmeService.buscarID(id));
    }

    //Recebe um ID na URL e manda apagar esse filme do banco
    @DeleteMapping("/{id}")
    public ResponseEntity<String> apagarId(@PathVariable long id) {
        return ResponseEntity.ok(filmeService.deletar(id));
    }

    //Recebe um ID e dados novos para atualizar um filme que já existe
    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable long id, @RequestBody FilmeRequest request) {
        return ResponseEntity.ok(filmeService.alterar(id, request));
    }
}
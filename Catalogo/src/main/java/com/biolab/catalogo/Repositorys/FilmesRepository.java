package com.biolab.catalogo.Repositorys;


import com.biolab.catalogo.Entities.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filme, Long> {
}

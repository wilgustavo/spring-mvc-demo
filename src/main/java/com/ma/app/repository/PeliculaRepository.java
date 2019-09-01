package com.ma.app.repository;

import com.ma.app.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

    @Override
    @EntityGraph(attributePaths = {"detalle", "horarios"})
    Page<Pelicula> findAll(Pageable page);

    @Override
    @EntityGraph(attributePaths = {"detalle", "horarios"})
    List<Pelicula> findAll();

}

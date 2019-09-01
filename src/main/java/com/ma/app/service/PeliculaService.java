package com.ma.app.service;

import java.util.List;

import com.ma.app.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PeliculaService {

    List<Pelicula> buscarTodas();
    Page<Pelicula> buscarTodas(Pageable page);
    Pelicula buscarPorId(int id);
    void insertar(Pelicula pelicula);
    void eliminar(int id);
    List<String> buscarGeneros();

}

package com.ma.app.service;

import java.util.List;

import com.ma.app.model.Pelicula;

public interface PeliculaService {

    List<Pelicula> buscarTodas();
    Pelicula buscarPorId(int id);
    void insertar(Pelicula pelicula);
    List<String> buscarGeneros();

}

package com.ma.app.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ma.app.model.Pelicula;
import com.ma.app.util.FechaUtil;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private List<Pelicula> lista;

    public PeliculaServiceImpl() {
        lista = getListaEjemplo();
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return lista;
    }

    @Override
    public Pelicula buscarPorId(int id) {
        return lista.stream().filter(pelicula -> pelicula.getId() == id).findAny().orElse(null);
    }

    private List<Pelicula> getListaEjemplo() {
        return new LinkedList<>(Arrays.asList(
                new Pelicula.Builder().id(1).titulo("Star Wars").duracion(128).clasificacion("B").genero("Aventura")
                        .imagen("starwars.jpg").fechaEstreno(FechaUtil.getISODate("2017-05-20")).build(),
                new Pelicula.Builder().id(2).titulo("Power Rangers").duracion(120).clasificacion("B").genero("Aventura")
                        .fechaEstreno(FechaUtil.getISODate("2017-05-20")).build(),
                new Pelicula.Builder().id(3).titulo("Dumbo").duracion(132).clasificacion("A").genero("Infantil")
                        .imagen("dumbo.jpg").fechaEstreno(FechaUtil.getISODate("2017-05-21")).build(),
                new Pelicula.Builder().id(4).titulo("John Wick 2").duracion(106).clasificacion("B").genero("Accion")
                        .imagen("wick.jpg").fechaEstreno(FechaUtil.getISODate("2017-06-02")).estatus("Inactiva")
                        .build(),
                new Pelicula.Builder().id(5).titulo("Life: vida inteligente").duracion(104).clasificacion("B")
                        .genero("Drama").imagen("estreno5.png").fechaEstreno(FechaUtil.getISODate("2017-06-10"))
                        .build()));
    }

    @Override
    public void insertar(Pelicula pelicula) {
        lista.add(pelicula);
    }

    @Override
    public List<String> buscarGeneros() {
        return Arrays.asList("Accion", "Aventura", "Clasicas", "Comedia Romantica", "Drama", "Terror", "Infantil",
                "Accion y Aventura", "Romantica", "Ciencia Ficcion");
    }

}

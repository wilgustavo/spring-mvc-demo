package com.ma.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ma.app.model.Pelicula;
import com.ma.app.util.FechaUtil;

@Service
public class PeliculaServiceImpl  implements PeliculaService{

    private List<Pelicula> lista;

    public PeliculaServiceImpl() {
        lista = getListaEjemplo();
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return lista;
    }

    private List<Pelicula> getListaEjemplo() {
        return Arrays.asList(
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
                        .build());
    }

}

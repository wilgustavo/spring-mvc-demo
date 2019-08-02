package com.ma.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ma.app.model.Pelicula;
import com.ma.app.util.FechaUtil;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        return "home";
    }

    @GetMapping("/")
    public String mostrarPrincipal(Model model) {
        List<Pelicula> peliculas = getListaEjemplo();
        model.addAttribute("peliculas", peliculas);

        return "home";
    }

    @GetMapping("/detail")
    public String mostrarDetalle(Model model) {
        String tituloPelicula = "Rapido y furioso";
        int duracion = 136;
        double precioEntrada = 50.0;

        model.addAttribute("titulo", tituloPelicula);
        model.addAttribute("duracion", duracion);
        model.addAttribute("precio", precioEntrada);
        return "detalle";
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
                        .imagen("wick.jpg").fechaEstreno(FechaUtil.getISODate("2017-06-02")).estatus("Inactiva").build());
    }

}

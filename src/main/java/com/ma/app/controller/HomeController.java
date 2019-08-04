package com.ma.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ma.app.model.Pelicula;
import com.ma.app.util.FechaUtil;

@Controller
public class HomeController {

    private static final int MAX_FECHAS = 5;
    private static final Logger logger = Logger.getLogger(HomeController.class.getName());

    @GetMapping("/home")
    public String goHome() {
        return "home";
    }

    @PostMapping("/search")
    public String buscar(@RequestParam("fecha") String fecha, Model model) {
        logger.log(Level.INFO, "Buscando películas para la fecha {0}", fecha);
        buscarPeliculasPorFecha(fecha, model);
        return "home";
    }

    @GetMapping("/")
    public String mostrarPrincipal(Model model) {
        buscarPeliculasPorFecha(FechaUtil.getISOString(new Date()), model);
        return "home";
    }

    @GetMapping("/detail")
    public String mostrarDetalle(@RequestParam("idMovie") int idPelicula, @RequestParam("fecha") String fecha,
            Model model) {
        logger.log(Level.INFO, "Buscando horarios de la pelicula {0} para la fecha {1}",
                new Object[] { idPelicula, fecha });

        String tituloPelicula = "Rapido y furioso";
        int duracion = 136;
        double precioEntrada = 50.0;

        model.addAttribute("titulo", tituloPelicula);
        model.addAttribute("duracion", duracion);
        model.addAttribute("precio", precioEntrada);
        return "detalle";
    }

    private void buscarPeliculasPorFecha(String fecha, Model model) {
        model.addAttribute("peliculas", getListaEjemplo());
        model.addAttribute("fechas", FechaUtil.getNextDays(MAX_FECHAS));
        model.addAttribute("fechaBusqueda", fecha);
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

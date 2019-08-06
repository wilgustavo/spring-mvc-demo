package com.ma.app.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ma.app.service.PeliculaService;
import com.ma.app.util.FechaUtil;

@Controller
public class HomeController {

    private static final int MAX_FECHAS = 5;
    private static final Logger logger = Logger.getLogger(HomeController.class.getName());

    @Autowired
    private PeliculaService peliculaSevice;

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

        model.addAttribute("pelicula", peliculaSevice.buscarPorId(idPelicula));
        return "detalle";
    }

    private void buscarPeliculasPorFecha(String fecha, Model model) {
        model.addAttribute("peliculas", peliculaSevice.buscarTodas());
        model.addAttribute("fechas", FechaUtil.getNextDays(MAX_FECHAS));
        model.addAttribute("fechaBusqueda", fecha);
    }

}

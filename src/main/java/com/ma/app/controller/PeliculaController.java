package com.ma.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ma.app.model.Pelicula;
import com.ma.app.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    private static final Logger logger = Logger.getLogger(PeliculaController.class.getName());

    @Autowired
    private PeliculaService peliculaService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("peliculas", peliculaService.buscarTodas());
        return "peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear() {
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar(Pelicula pelicula, BindingResult result) {
        if(result.hasErrors()) {
            logger.log(Level.WARNING, "Existen errores {0}", result.getAllErrors());
        } else {
            logger.log(Level.INFO, "Se guarda pelicula {0}", pelicula);
            peliculaService.insertar(pelicula);
        }
        return "peliculas/formPelicula";
    }
}
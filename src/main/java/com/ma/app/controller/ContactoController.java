package com.ma.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ma.app.model.Contacto;
import com.ma.app.service.PeliculaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ContactoController
 */
@Controller
public class ContactoController {

    private static final Logger logger = Logger.getLogger(PeliculaController.class.getName());

    private final PeliculaService peliculaService;

    public ContactoController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("/contacto")
    public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) {
        model.addAttribute("generos", peliculaService.buscarGeneros());
        model.addAttribute("tipos", tipoNotificaciones());
        return "formContacto";
    }

    @PostMapping("/contacto")
    public String guardar(@ModelAttribute Contacto contacto) {
        logger.log(Level.INFO, "Se guarda el contacto: {0}", contacto);
        return "redirect:/contacto";
    }

    private List<String> tipoNotificaciones() {
        return Arrays.asList("Estrenos", "Promociones", "Noticias", "Preventas");
    }

}

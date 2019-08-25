package com.ma.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ma.app.model.Horario;
import com.ma.app.service.PeliculaService;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HorarioController
 */
@Controller
@RequestMapping("/horarios")
public class HorarioController {

    private static final Logger logger = Logger.getLogger(PeliculaController.class.getName());

    private final PeliculaService peliculaService;

    public HorarioController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Horario horario, Model model) {
        model.addAttribute("peliculas", peliculaService.buscarTodas());
        return "horarios/formHorario";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model) {
        if(result.hasErrors()) {
            logger.log(Level.WARNING, "Existen errores {0}", result.getAllErrors());
            model.addAttribute("peliculas", peliculaService.buscarTodas());
            return "horarios/formHorario";
        }

        logger.log(Level.INFO, "Guardar horario {0}", horario);
        return "redirect:/horarios/create";
    }

}

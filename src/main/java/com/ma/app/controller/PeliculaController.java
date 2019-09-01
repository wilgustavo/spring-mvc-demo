package com.ma.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ma.app.model.Pelicula;
import com.ma.app.service.PeliculaService;
import com.ma.app.util.ImagenUtil;

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
    public String mostrarIndex(Model model, Pageable page) {
        model.addAttribute("peliculas", peliculaService.buscarTodas(page));
        return "peliculas/listPeliculas";
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Pelicula pelicula) {
        return "peliculas/formPelicula";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idPelicula, Model model) {
        Pelicula pelicula = peliculaService.buscarPorId(idPelicula);
        model.addAttribute("pelicula", pelicula);
        return "peliculas/formPelicula";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
        logger.log(Level.INFO, "Se elimina la pelicula {0}", idPelicula);
        peliculaService.eliminar(idPelicula);
        attributes.addFlashAttribute("mensaje", "El registro fue eliminado");
        return "redirect:/peliculas/index";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen") MultipartFile multipartFile,
                          HttpServletRequest request) {
        if(result.hasErrors()) {
            logger.log(Level.WARNING, "Existen errores {0}", result.getAllErrors());
            return "peliculas/formPelicula";
        }

        if (!multipartFile.isEmpty()) {
            pelicula.setImagen(ImagenUtil.guardarImagen(multipartFile, request));
        }

        logger.log(Level.INFO, "Se guarda pelicula {0}", pelicula);
        peliculaService.insertar(pelicula);
        attributes.addFlashAttribute("mensaje", "El registro fue guardado");
        return "redirect:/peliculas/index";
    }

    @ModelAttribute("generos")
    public List<String> getGeneros() {
        return peliculaService.buscarGeneros();
    }
}

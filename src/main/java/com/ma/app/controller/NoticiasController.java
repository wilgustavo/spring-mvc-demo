package com.ma.app.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ma.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

    private static final Logger logger = Logger.getLogger(HomeController.class.getName());

    @GetMapping("/create")
    public String crear() {
        return "noticias/formNoticia";
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus,
            @RequestParam("detalle") String detalle) {

        logger.log(Level.INFO, "Titulo: {0}, estatus {1}, detalle: {2}", new Object[] { titulo, estatus, detalle });

        Noticia noticia = new Noticia(titulo, detalle, estatus);

        logger.log(Level.INFO, "Se crea objeto noticia {0}", noticia);
        return "noticias/formNoticia";
    }

}

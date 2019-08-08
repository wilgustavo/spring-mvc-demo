package com.ma.app.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ma.app.model.Noticia;
import com.ma.app.service.NoticiaService;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

    private static final Logger logger = Logger.getLogger(NoticiaController.class.getName());

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/create")
    public String crear() {
        return "noticias/formNoticia";
    }

    @PostMapping("/save")
    public String guardar(Noticia noticia) {
        logger.log(Level.INFO, "Se crea objeto noticia {0}", noticia);
        noticiaService.guardar(noticia);

        return "noticias/formNoticia";
    }

}

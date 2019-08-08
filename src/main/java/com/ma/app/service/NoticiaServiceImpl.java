package com.ma.app.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.ma.app.controller.NoticiaController;
import com.ma.app.model.Noticia;

@Service
public class NoticiaServiceImpl implements NoticiaService {

    private static final Logger logger = Logger.getLogger(NoticiaController.class.getName());

    @Override
    public void guardar(Noticia noticia) {
        logger.log(Level.INFO, "Se guarda noticia {0}", noticia);
    }

}

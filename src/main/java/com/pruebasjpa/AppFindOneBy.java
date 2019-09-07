package com.pruebasjpa;

import java.util.Optional;

import org.springframework.context.ApplicationContext;

import com.ma.app.model.Pelicula;
import com.ma.app.repository.PeliculaRepository;

/**
 * AppKeywordFindBy
 */
public class AppFindOneBy {

    public static void main(String[] args) {
        ApplicationContext context = ContextUtil.getContext();
        PeliculaRepository peliculaRepository = context.getBean(PeliculaRepository.class);
        Optional<Pelicula> optionalPelicula = peliculaRepository.findFirstByGenero("Accion");
        PrintUtil.imprimir(optionalPelicula);
    }
}

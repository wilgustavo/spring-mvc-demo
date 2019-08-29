package com.pruebasjpa;

import java.util.Optional;

import com.ma.app.model.Noticia;
import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppUpdate
 */
public class AppUpdate {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        Optional<Noticia> optional =  noticiaRepository.findById(1);
        if(optional.isPresent()) {
            Noticia noticia = optional.get();
            noticia.setEstatus("Inactiva");
            noticiaRepository.save(noticia);
        }

        context.close();
    }

}

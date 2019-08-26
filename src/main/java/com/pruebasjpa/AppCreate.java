package com.pruebasjpa;

import com.ma.app.model.Noticia;
import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppCreate
 */
public class AppCreate {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        Noticia noticia = new Noticia("Próximo extreno: Superman 2", "El mes próximo se extrena esta película", "Activa");
        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        noticiaRepository.save(noticia);

        context.close();
    }

}

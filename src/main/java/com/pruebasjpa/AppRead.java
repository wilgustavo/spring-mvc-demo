package com.pruebasjpa;

import java.util.Optional;

import com.ma.app.model.Noticia;
import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppRead
 */
public class AppRead {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        Optional<Noticia> noticia = noticiaRepository.findById(1);
        System.out.println(noticia.get());

        context.close();

    }
}

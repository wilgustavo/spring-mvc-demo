package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppDelete
 */
public class AppDelete {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        int idNoticia = 2;
        if (noticiaRepository.existsById(idNoticia)) {
            noticiaRepository.deleteById(idNoticia);
        }

        context.close();
    }

}

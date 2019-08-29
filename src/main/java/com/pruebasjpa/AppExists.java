package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppExists
 */
public class AppExists {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        int idNoticia = 1;
        System.out.println(noticiaRepository.existsById(idNoticia));

        context.close();
    }

}

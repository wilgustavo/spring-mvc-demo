package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppDeleteAll
 */
public class AppDeleteAll {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        noticiaRepository.deleteAll();

        context.close();
    }

}

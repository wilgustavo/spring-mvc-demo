package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppFindAll
 */
public class AppFindAll {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        noticiaRepository.findAll().stream().forEach(n -> {System.out.println(n); });

        context.close();
    }

}

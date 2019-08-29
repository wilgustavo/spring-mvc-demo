package com.pruebasjpa;

import java.util.Arrays;

import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppFindAllById
 */
public class AppFindAllById {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        noticiaRepository
            .findAllById(Arrays.asList(12, 4, 5, 6))
            .stream()
            .forEach(n -> {System.out.println(n); });

        context.close();
    }


}

package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * AppFindAll
 */
public class AppFindAll {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        noticiaRepository
            .findAll(PageRequest.of(0, 6, Sort.by("titulo")))
            .stream()
            .forEach(PrintUtil::imprimir);

        context.close();
    }

}

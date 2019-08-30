package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;
import com.ma.app.util.FechaUtil;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppKeywordAnd
 */
public class AppKeywordOr {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        noticiaRepository
            .findByEstatusOrFecha("Inactiva", FechaUtil.getISODate("2017-09-01"))
            .stream()
            .forEach(PrintUtil::imprimir);

        context.close();
    }

}

package com.pruebasjpa;

import com.ma.app.repository.NoticiaRepository;
import com.ma.app.util.FechaUtil;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * AppKeywordFindBy
 */
public class AppKeywordFindBy {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring/root-context.xml");

        NoticiaRepository noticiaRepository = context.getBean(NoticiaRepository.class);
        ListarPorFecha(noticiaRepository);

        context.close();
    }

    public static void ListarPorFecha(NoticiaRepository noticiaRepository) {
        noticiaRepository
            .findByFecha(FechaUtil.getISODate("2017-09-01"))
            .stream()
            .forEach(PrintUtil::imprimir);
    }

    public static void ListarPorEstatus(NoticiaRepository noticiaRepository) {
        noticiaRepository
            .findByEstatus("Activa")
            .stream()
            .forEach(PrintUtil::imprimir);
    }
}

package com.pruebasjpa;

import com.ma.app.repository.PeliculaRepository;
import org.springframework.context.ApplicationContext;

public class PeliFindAll {

    public static void main(String[] args) {
        ApplicationContext context = ContextUtil.getContext();
        PeliculaRepository repository = context.getBean(PeliculaRepository.class);
        repository.findAll().stream().forEach(PrintUtil::imprimir);
    }
}

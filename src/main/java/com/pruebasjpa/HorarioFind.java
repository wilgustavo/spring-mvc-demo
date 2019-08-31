package com.pruebasjpa;

import com.ma.app.repository.HorarioRepository;
import com.ma.app.util.FechaUtil;
import org.springframework.context.ApplicationContext;

public class HorarioFind {

    public static void main(String[] args) {
        ApplicationContext context = ContextUtil.getContext();
        HorarioRepository repository = context.getBean(HorarioRepository.class);
        repository
            .findByFecha(FechaUtil.getISODate("2019-09-01"))
            .stream()
            .forEach(PrintUtil::imprimir);
    }
}

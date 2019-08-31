package com.pruebasjpa;

import com.ma.app.model.Pelicula;
import com.ma.app.repository.PeliculaRepository;
import com.ma.app.util.FechaUtil;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

public class PeliGetHorarios {

    public static void main(String[] args) {
        ApplicationContext context = ContextUtil.getContext();
        PeliculaRepository repository = context.getBean(PeliculaRepository.class);
        Optional<Pelicula> pelicula = repository.findById(2);
        if (pelicula.isPresent()) {
            pelicula.get().getHorarios().stream().forEach(horario -> {
                System.out.printf("Horario: %s %s %s %n",
                    FechaUtil.getISOString(horario.getFecha()), horario.getHora(), horario.getSala());
            });
        }
    }

}

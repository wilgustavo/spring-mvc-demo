package com.ma.app.service;

import com.ma.app.model.Pelicula;
import com.ma.app.repository.PeliculaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Page<Pelicula> buscarTodas(Pageable page) {
        return peliculaRepository.findAll(page);
    }

    @Override
    public Pelicula buscarPorId(int id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public void insertar(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminar(int id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public List<String> buscarGeneros() {
        return Arrays.asList("Accion", "Aventura", "Clasicas", "Comedia Romantica", "Drama", "Terror", "Infantil",
                "Accion y Aventura", "Romantica", "Ciencia Ficcion");
    }
}

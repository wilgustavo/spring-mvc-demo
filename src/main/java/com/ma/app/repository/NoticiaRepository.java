package com.ma.app.repository;

import java.util.Date;
import java.util.List;

import com.ma.app.model.Noticia;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * NoticaRepository
 */
public interface NoticiaRepository  extends JpaRepository<Noticia, Integer> {

    List<Noticia> findByEstatus(String estatus);
    List<Noticia> findByFecha(Date fecha);
    List<Noticia> findByEstatusAndFecha(String estatus, Date fecha);
    List<Noticia> findByEstatusOrFecha(String estatus, Date fecha);
    List<Noticia> findByFechaBetween(Date desde, Date hasta);


}

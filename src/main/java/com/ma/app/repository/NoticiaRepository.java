package com.ma.app.repository;

import com.ma.app.model.Noticia;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * NoticaRepository
 */
public interface NoticiaRepository  extends JpaRepository<Noticia, Integer> {


}

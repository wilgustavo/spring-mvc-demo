package com.ma.app.repository;

import com.ma.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    List<Horario> findByFecha(Date fecha);
}

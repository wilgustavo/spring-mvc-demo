package com.ma.app.service;

import java.util.Date;
import java.util.List;

import com.ma.app.model.Horario;

public interface HorarioService {

    List<Horario> buscarPorIdPelicula(int idpelicula, Date fecha);

}

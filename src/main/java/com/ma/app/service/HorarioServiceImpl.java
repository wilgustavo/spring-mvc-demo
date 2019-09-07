package com.ma.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ma.app.model.Horario;
import com.ma.app.repository.HorarioRepository;

@Service
public class HorarioServiceImpl implements HorarioService {

    private HorarioRepository horarioRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }

    @Override
    public List<Horario> buscarPorIdPelicula(int idpelicula, Date fecha) {
        return horarioRepository.findByPeliculaIdAndFechaOrderByHora(idpelicula, fecha);
    }

}

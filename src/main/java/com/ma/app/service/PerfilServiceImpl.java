package com.ma.app.service;

import org.springframework.stereotype.Service;

import com.ma.app.model.Perfil;
import com.ma.app.repository.PerfilRepository;

@Service
public class PerfilServiceImpl implements PerfilService {

    private PerfilRepository perfilRepository;

    public PerfilServiceImpl(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public void guardar(Perfil perfil) {
        perfilRepository.save(perfil);
    }

}

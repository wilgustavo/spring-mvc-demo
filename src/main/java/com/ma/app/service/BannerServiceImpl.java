package com.ma.app.service;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ma.app.model.Banner;

@Service
public class BannerServiceImpl implements BannerService {

    private List<Banner> lista;

    public BannerServiceImpl() {
        lista = new LinkedList<>(getEjemplos());
    }

    @Override
    public void insertar(Banner banner) {
        lista.add(banner);
    }

    @Override
    public List<Banner> buscarTodos() {
        return lista;
    }

    private List<Banner> getEjemplos() {
        return Arrays.asList(
            new Banner(1, "Titulo 1", new Date(), "slide1.jpg", Banner.ESTATUS_ACTIVO),
            new Banner(2, "Titulo 2", new Date(), "slide2.jpg", Banner.ESTATUS_ACTIVO),
            new Banner(3, "Titulo 3", new Date(), "slide3.jpg", Banner.ESTATUS_ACTIVO),
            new Banner(4, "Titulo 4", new Date(), "slide4.jpg", Banner.ESTATUS_ACTIVO));
    }

}

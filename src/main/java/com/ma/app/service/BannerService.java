package com.ma.app.service;

import java.util.List;

import com.ma.app.model.Banner;

public interface BannerService {

    void insertar(Banner banner);
    List<Banner> buscarTodos();

}

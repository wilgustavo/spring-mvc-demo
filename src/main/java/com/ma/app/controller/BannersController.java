package com.ma.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ma.app.service.BannerService;

@Controller
@RequestMapping("/banners")
public class BannersController {

    private BannerService bannerService;

    public BannersController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("banners", bannerService.buscarTodos());
        return "banners/listBanners";
    }
}

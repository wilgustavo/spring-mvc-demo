package com.ma.app.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ma.app.model.Banner;
import com.ma.app.service.BannerService;
import com.ma.app.util.ImagenUtil;

@Controller
@RequestMapping("/banners")
public class BannersController {

    private static final Logger logger = Logger.getLogger(PeliculaController.class.getName());

    private BannerService bannerService;

    public BannersController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        model.addAttribute("banners", bannerService.buscarTodos());
        return "banners/listBanners";
    }

    @GetMapping("/create")
    public String crear() {
        return "banners/formBanner";
    }

    @PostMapping("/save")
    public String guardar(Banner banner, BindingResult result, RedirectAttributes attributes,
            @RequestParam("archivoImagen") MultipartFile multipartFile,
            HttpServletRequest request)  {

        if(result.hasErrors()) {
            logger.log(Level.WARNING, "Existen errores {0}", result.getAllErrors());
            return "banners/formBanner";
        }

        if (!multipartFile.isEmpty()) {
            banner.setArchivo(ImagenUtil.guardarImagen(multipartFile, request));
        }

        logger.log(Level.INFO, "se guarda banner {0}", banner);
        bannerService.insertar(banner);
        attributes.addFlashAttribute("mensaje", "El registro fue guardado");
        return "redirect:/banners/index";
    }
}

package com.ma.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ma.app.service.BannerService;
import com.ma.app.service.HorarioService;
import com.ma.app.service.PeliculaService;
import com.ma.app.util.FechaUtil;

@Controller
public class HomeController {

    private static final int MAX_FECHAS = 5;
    private static final Logger logger = Logger.getLogger(HomeController.class.getName());

    private PeliculaService peliculaService;
    private BannerService bannerService;
    private HorarioService horarioService;

    public HomeController(PeliculaService peliculaService, BannerService bannerService, HorarioService horarioService) {
        this.peliculaService = peliculaService;
        this.bannerService = bannerService;
        this.horarioService = horarioService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
    }

    @GetMapping("/home")
    public String goHome() {
        return "home";
    }

    @PostMapping("/search")
    public String buscar(@RequestParam("fecha") String fecha, Model model) {
        logger.log(Level.INFO, "Buscando películas para la fecha {0}", fecha);
        buscarPeliculasPorFecha(fecha, model);
        model.addAttribute("banners", bannerService.buscarTodos());
        return "home";
    }

    @GetMapping("/")
    public String mostrarPrincipal(Model model) {
        buscarPeliculasPorFecha(FechaUtil.getISOString(new Date()), model);
        model.addAttribute("banners", bannerService.buscarTodos());
        return "home";
    }

    @GetMapping("/detail")
    public String mostrarDetalle(@RequestParam("idMovie") int idPelicula, @RequestParam("fecha") Date fecha,
            Model model) {
        logger.log(Level.INFO, "Buscando horarios de la pelicula {0} para la fecha {1}",
                new Object[] { idPelicula, fecha });

        model.addAttribute("horarios", horarioService.buscarPorIdPelicula(idPelicula, fecha));
        model.addAttribute("fechaBusqueda", fecha);
        model.addAttribute("pelicula", peliculaService.buscarPorId(idPelicula));
        return "detalle";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "formLogin";
    }

    @GetMapping("/admin")
    public String mostrarPrincipalAdmin(Authentication authentication) {
        logger.log(Level.INFO, "Nombre de usuario: {0}", authentication.getName());
        authentication.getAuthorities().forEach(auth -> {
            logger.log(Level.INFO, "Roles del usuario {0}", auth.getAuthority());
        });
        return "admin";
    }

    private void buscarPeliculasPorFecha(String fecha, Model model) {
        model.addAttribute("peliculas", peliculaService.buscarTodas());
        model.addAttribute("fechas", FechaUtil.getNextDays(MAX_FECHAS));
        model.addAttribute("fechaBusqueda", fecha);
    }

}

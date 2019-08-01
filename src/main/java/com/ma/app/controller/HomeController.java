package com.ma.app.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ma.app.model.Pelicula;
import com.ma.app.util.FechaUtil;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
	    List<Pelicula> peliculas = getListaEjemplo();
        model.addAttribute("peliculas", peliculas);

	    return "home";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapido y furioso";
		int duracion = 136;
		double precioEntrada = 50.0;

		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}

	private List<Pelicula> getListaEjemplo() {
	    return Arrays.asList(
	      new Pelicula(1, "Power Ranger", 120, "B", "Aventura", FechaUtil.getISODate("2017-05-02")),
	      new Pelicula(2, "La bella y la bestia", 132, "A", "Infantil", FechaUtil.getISODate("2017-05-20")),
	      new Pelicula(3, "Contratiempo", 106, "B", "Thriller", FechaUtil.getISODate("2017-05-20")));
	}

}


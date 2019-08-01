package com.ma.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
	    List<String> peliculas = new LinkedList<>();
	    peliculas.add("Rapido y furioso");
        peliculas.add("Aliens");
        peliculas.add("Toy Story 4");
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

}


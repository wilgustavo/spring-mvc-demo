package com.ma.app.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ma.app.model.Pelicula;
import com.ma.app.service.PeliculaService;
import com.ma.app.util.FechaUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:webapp/WEB-INF/spring/dispatcher-servlet.xml", "file:webapp/WEB-INF/spring/root-context.xml"})
public class HomeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PeliculaService peliculaService;

    @InjectMocks
    private HomeController homeController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void deberia_listar_peliculas() throws Exception {
        when(peliculaService.buscarTodas()).thenReturn(getPeliculasEjemplos());
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("peliculas", is((getPeliculasEjemplos()))));
    }

    @Test
    public void deberia_buscar_pelicula_por_id() throws Exception {
        when(peliculaService.buscarPorId(154)).thenReturn(getEjemplo());
        mockMvc.perform(get("/detail").param("idMovie", "154").param("fecha", "2017-05-20"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("pelicula", getEjemplo()));
    }

    private List<Pelicula> getPeliculasEjemplos() {
        return Arrays.asList(
                new Pelicula.Builder().id(1).titulo("Star Wars").duracion(128).clasificacion("B").genero("Aventura")
                        .imagen("starwars.jpg").fechaEstreno(FechaUtil.getISODate("2017-05-20")).build(),
                new Pelicula.Builder().id(2).titulo("Power Rangers").duracion(120).clasificacion("B").genero("Aventura")
                        .fechaEstreno(FechaUtil.getISODate("2017-05-20")).build());
    }

    private Pelicula getEjemplo() {
        return new Pelicula.Builder().id(1).titulo("Star Wars").duracion(128).clasificacion("B").genero("Aventura")
        .imagen("starwars.jpg").fechaEstreno(FechaUtil.getISODate("2017-05-20")).build();
    }

}
